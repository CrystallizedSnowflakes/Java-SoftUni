package softuni.exam.util;

import softuni.exam.util.api.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readFromFilePath(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T)unmarshaller.unmarshal(new FileReader(filePath));
    }
}
