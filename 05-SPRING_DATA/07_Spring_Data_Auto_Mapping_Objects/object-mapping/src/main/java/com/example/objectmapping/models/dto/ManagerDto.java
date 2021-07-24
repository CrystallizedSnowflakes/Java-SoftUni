package com.example.objectmapping.models.dto;


import java.util.Set;

public class ManagerDto extends BasicEmployeeDto{

    private Set<EmployeeDto> subordinates;

    public ManagerDto() {
    }

    public Set<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
