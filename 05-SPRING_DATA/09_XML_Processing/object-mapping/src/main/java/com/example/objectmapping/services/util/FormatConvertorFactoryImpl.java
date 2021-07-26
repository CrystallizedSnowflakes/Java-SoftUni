package com.example.objectmapping.services.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FormatConvertorFactoryImpl implements FormatConvertorFactory {

    private final FormatConverter xml;
    private final FormatConverter json;

    public FormatConvertorFactoryImpl(
            @Qualifier("xml-format-convertor") FormatConverter xml,
            @Qualifier("json-format-convertor") FormatConverter json) {
        this.xml = xml;
        this.json = json;
    }

    @Override
    public FormatConverter create(String formatType) {

        return switch (formatType.toLowerCase()) {
            case "xml" -> this.xml;
            case "json" -> this.json;
            default -> null;
        };
    }
}
