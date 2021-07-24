package com.example.objectmapping.services;

import com.example.objectmapping.models.dto.EmployeeCreateRequestDto;
import com.example.objectmapping.models.dto.EmployeeCreateResponseDto;
import com.example.objectmapping.models.dto.EmployeeDto;
import com.example.objectmapping.models.dto.ManagerDto;
import com.example.objectmapping.models.entities.Employee;
import com.example.objectmapping.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDto findOne(Long id) {
        // returns EmployeeDto
        return mapper.map(this.employeeRepository.findById(id).orElseThrow(),
                ManagerDto.class);

/*        var employee = this.employeeRepository.findById(id).orElseThrow();
        var dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSalary(employee.getSalary());
        return dto;*/
    }

    @Override
    public List<ManagerDto> findAll() {

/*        return this.employeeRepository.findAll()
                .stream()
                .map(e -> this.mapper.map(e, ManagerDto.class))
                .collect(Collectors.toList());*/

        return mapper.map(this.employeeRepository.findAll(),
                new TypeToken<List<ManagerDto>>() {}.getType());
    }

    @Override                            // accept DTO
    public EmployeeCreateResponseDto save(EmployeeCreateRequestDto createRequestDto) {

        // Map DTO (source) to Entity (destination)
        Employee entity = this.mapper.map(createRequestDto, Employee.class);
        // Save to DB
        entity = this.employeeRepository.save(entity);

        // Map savedEntity to another DTO
        EmployeeCreateResponseDto responseDto = this.mapper.map(entity, EmployeeCreateResponseDto.class);
        // return this DTO
        return responseDto;

/*        return this.mapper.map(
                this.employeeRepository.save(
                        this.mapper.map(
                                createRequestDto,
                                Employee.class
                        )
                ),
                EmployeeCreateResponseDto.class
        );*/
    }
}
