package com.example.xmlex.util.impl;

import com.example.xmlex.util.XMLParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XMLParserImpl implements XMLParser {

    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {

        this.jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(filePath));
    }

    @Override
    public <T> void writeToFile(String filePath, T entity) throws JAXBException {

        this.jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(entity, new File(filePath));
    }
}
