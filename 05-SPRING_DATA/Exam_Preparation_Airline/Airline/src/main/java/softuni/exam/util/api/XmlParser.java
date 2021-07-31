package softuni.exam.util.api;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T readFromFilePath(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;
}
