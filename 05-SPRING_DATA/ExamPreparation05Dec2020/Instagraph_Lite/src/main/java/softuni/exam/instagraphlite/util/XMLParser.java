package softuni.exam.instagraphlite.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XMLParser {

    <T> T readFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;
}
