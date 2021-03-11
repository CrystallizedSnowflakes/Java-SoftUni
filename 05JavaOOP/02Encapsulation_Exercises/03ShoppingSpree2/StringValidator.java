package e03ShoppingSpree2;

public class StringValidator {

    // The Validator can NOT be instantiated => private constructor
    private StringValidator(){
    }

    public static boolean isNameValid(String name){

        // !name.isEmpty() && !name.equals("\\s+");
        return name != null && !name.trim().isEmpty();
    }
}
