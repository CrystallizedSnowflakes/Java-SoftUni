package softuni.exam.service.api;


import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

//ToDo - Before start App implement this Service and set areImported to return false
public interface TicketService {

    boolean areImported();

    String readTicketsFileContent() throws IOException;
	
	String importTickets() throws JAXBException, FileNotFoundException;

}
