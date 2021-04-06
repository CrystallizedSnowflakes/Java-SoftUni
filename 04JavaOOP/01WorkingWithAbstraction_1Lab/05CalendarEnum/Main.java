package a05CalendarEnum;

public class Main {
    public static void main(String[] args) {

        WeekDay monday = WeekDay.MONDAY;

        System.out.println(monday.getNumericRepresentation()); // 1 -> my numeration
        System.out.println(monday.ordinal()); // 0 -> starts from 0

        WeekDay[] values = WeekDay.values();

        for (WeekDay value : values) {
            System.out.println(value.getName());
        }
    }
}
