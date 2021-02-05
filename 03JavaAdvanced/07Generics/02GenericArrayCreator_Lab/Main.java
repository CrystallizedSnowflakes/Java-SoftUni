package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(10, "Java");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 2);

        for (String text : strings) {
            System.out.println(text);
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
