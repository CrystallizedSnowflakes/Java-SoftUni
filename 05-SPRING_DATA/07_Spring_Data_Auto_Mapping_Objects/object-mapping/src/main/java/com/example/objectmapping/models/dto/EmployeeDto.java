package com.example.objectmapping.models.dto;

import java.math.BigDecimal;

public class EmployeeDto extends BasicEmployeeDto{

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
