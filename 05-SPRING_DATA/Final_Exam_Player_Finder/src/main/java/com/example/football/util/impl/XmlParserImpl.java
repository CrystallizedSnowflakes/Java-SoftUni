package com.example.football.util.impl;

import com.example.football.util.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readFromFilePath(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {
        this.jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(filePath));
    }
}
