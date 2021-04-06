package a04Person;


// Creating a custom Unchecked Exception

public class InvalidPersonNameException extends RuntimeException{ // Unchecked Exception
    public InvalidPersonNameException(String message){
        super(message);
    }
}

// if extends Exception will be -> Checked Exception
