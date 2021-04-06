package a05CalendarEnum;

public enum WeekDay {
    // By default ENUMS starts at 0
    // Every next value is incremented by one
    // Here are all instances of the class

    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

    private int numericRepresentation;
    private String name;

    private WeekDay(int numericRepresentation, String name){ // always PRIVATE no changes outside
        this.numericRepresentation = numericRepresentation;
        this.name = name;
    }

    public int getNumericRepresentation() {
        return numericRepresentation;
    }

    public String getName() {
        return name;
    }
}
