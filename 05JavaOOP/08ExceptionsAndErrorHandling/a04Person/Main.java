package a04Person;

public class Main {
    public static void main(String[] args) {

        try {
            new Person("", "last_name", 120);
        } catch (IllegalArgumentException | InvalidPersonNameException ex){
            System.out.println(ex.getMessage());
        }
    }
}
