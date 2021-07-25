package com.example.json_exercise.config;

import com.example.json_exercise.model.dto.CategoryByProductsCountDto;
import com.example.json_exercise.model.dto.SoldProductsCountAndProductsInfoDto;
import com.example.json_exercise.model.entity.Category;
import com.example.json_exercise.model.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Category, CategoryByProductsCountDto>() {
            @Override
            protected void configure() {
                map().setCategory(source.getName());
            }
        });

        return modelMapper;
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
}
