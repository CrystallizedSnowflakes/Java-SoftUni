package com.example.dto_game_store.config;

import com.example.dto_game_store.model.dto.GameAddDto;
import com.example.dto_game_store.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeenConfiguration {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {

                return mappingContext.getSource() == null
                        ? LocalDate.now()
                                        // parse from string to
                        : LocalDate.parse(mappingContext.getSource(),
                                        // localDate
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };

        modelMapper.addConverter(localDateConverter);

        modelMapper
                .typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper.map(GameAddDto::getThumbnailURL, Game::setImageThumbnail));


        return modelMapper;
    }
}
