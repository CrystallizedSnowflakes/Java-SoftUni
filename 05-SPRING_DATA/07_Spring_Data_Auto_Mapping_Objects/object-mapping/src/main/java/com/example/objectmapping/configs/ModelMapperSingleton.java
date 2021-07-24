package com.example.objectmapping.configs;

import com.example.objectmapping.models.dto.EmployeeDto;
import com.example.objectmapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class ModelMapperSingleton {

    private static ModelMapper mapper = null;

    public static ModelMapper getInstance(){
        if (mapper == null){
            mapper = new ModelMapper();
            mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
                @Override
                protected void configure() {
                    map().setIncome(source.getSalary());
                }
            });
        }
        return mapper;
    }
}
