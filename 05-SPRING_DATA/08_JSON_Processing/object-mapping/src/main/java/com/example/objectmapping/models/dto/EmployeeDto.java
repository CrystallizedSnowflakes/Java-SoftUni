package com.example.objectmapping.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class EmployeeDto extends BasicEmployeeDto{

    @Expose
    @SerializedName("salary")
    private BigDecimal income;

    public EmployeeDto() {
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
