package softuni.exam.service.api;



//import softuni.exam.models.entities.Passenger;

import softuni.exam.models.entities.Passenger;

import java.io.IOException;

//ToDo - Before start App implement this Service and set areImported to return false
public interface PassengerService {

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

    boolean isEntityExists(String email);

    String getPassengersOrderByTicketsCountDescendingThenByEmail();

    Passenger findByEmail(String email);
}
