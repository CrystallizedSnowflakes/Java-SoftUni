package com.example.objectmapping.models.dto;

public abstract class BasicEmployeeDto {

    private String firstName;
    private String lastName;

    public BasicEmployeeDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
