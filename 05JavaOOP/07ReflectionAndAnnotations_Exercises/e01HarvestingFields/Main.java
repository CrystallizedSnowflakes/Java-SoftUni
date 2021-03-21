package e01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String modifier = scanner.nextLine();
		while (!modifier.equals("HARVEST")){
			switch (modifier){
				case "private":
				case "protected":
				case "public":
					printFieldsBy(modifier);
					break;
				case "all":
					printAllDeclaredFields();
					break;
			}
			modifier = scanner.nextLine();
		}
	}

	private static void printAllDeclaredFields() {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			int fieldModifier = field.getModifiers();
			String accessModifier = Modifier.toString(fieldModifier);
			System.out.printf("%s %s %s%n", accessModifier, field.getType().getSimpleName(), field.getName());
		}

/*		Arrays.stream(fields)
				.forEach(f -> System.out.printf("%s %s %s%n",
						Modifier.toString(f.getModifiers()),
						f.getType(),
						f.getName()));*/
	}

	private static void printFieldsBy(String modifier) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			int fieldModifier = field.getModifiers();
			String accessModifier = Modifier.toString(fieldModifier);
			if (accessModifier.equals(modifier)) {
				System.out.printf("%s %s %s%n", accessModifier, field.getType().getSimpleName(), field.getName());
			}
		}

/*		Arrays.stream(fields)
				.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
				.forEach(f -> System.out.printf("%s %s %s%n",
						Modifier.toString(f.getModifiers()),
						f.getType(),
						f.getName()));*/
	}
}
