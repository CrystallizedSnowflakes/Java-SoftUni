package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.util.api.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.api.XmlParser;
import softuni.exam.util.XmlParserImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //2020-08-12 17:53:35

        modelMapper.addConverter(new Converter<String, LocalDateTime>() {

            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.parse(
                        mappingContext.getSource(), // from String
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // JSON file String pattern
            }
        });

        return modelMapper;
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

}
