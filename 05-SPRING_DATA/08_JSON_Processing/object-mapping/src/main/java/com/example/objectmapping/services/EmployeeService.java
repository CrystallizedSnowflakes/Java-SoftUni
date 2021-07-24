package com.example.objectmapping.services;

import com.example.objectmapping.models.dto.EmployeeCreateRequestDto;
import com.example.objectmapping.models.dto.EmployeeCreateResponseDto;
import com.example.objectmapping.models.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

    ManagerDto findOne(Long id);
    List<ManagerDto> findAll();
    EmployeeCreateResponseDto save(EmployeeCreateRequestDto createRequest);
}
