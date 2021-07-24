package com.example.objectmapping.models.dto;

import com.google.gson.annotations.Expose;

public class EmployeeCreateResponseDto extends EmployeeCreateRequestDto{

    @Expose
    private Long id;

    public EmployeeCreateResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
