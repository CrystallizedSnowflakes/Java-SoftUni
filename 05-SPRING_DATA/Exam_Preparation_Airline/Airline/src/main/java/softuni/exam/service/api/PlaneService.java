package softuni.exam.service.api;


import softuni.exam.models.entities.Plane;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface PlaneService {

    boolean areImported();

    String readPlanesFileContent() throws IOException;
	
	String importPlanes() throws JAXBException, FileNotFoundException;

    boolean isEntityExists(String registerNumber);

    Plane findByRegisterNumber(String registerNumber);
}
