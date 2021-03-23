package a04Person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setFirstName(String firstName) {
        validateStringField(firstName, "first");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        validateStringField(lastName, "last");
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("The age should be in the range [0 … 120]");
        }
        this.age = age;
    }

    private void validateStringField(String str, String fieldName){
        if (str == null || str.trim().isEmpty()){
            throw new InvalidPersonNameException("The " + fieldName + " name cannot be null ot empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
