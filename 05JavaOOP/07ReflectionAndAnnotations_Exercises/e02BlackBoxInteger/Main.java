package e02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        try {
            Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor(int.class);
            ctor.setAccessible(true);
            BlackBoxInt blackBoxInt = ctor.newInstance(0);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            String input = scanner.nextLine();
            while (!input.equals("END")){
                String[] tokens = input.split("_");
                String currentMethod = tokens[0];
                int value = Integer.parseInt(tokens[1]);

                Method method = clazz.getDeclaredMethod(currentMethod, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);

                System.out.println(innerValue.getInt(blackBoxInt));

                input = scanner.nextLine();
            }
        } catch (NoSuchMethodException |
                NoSuchFieldException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
