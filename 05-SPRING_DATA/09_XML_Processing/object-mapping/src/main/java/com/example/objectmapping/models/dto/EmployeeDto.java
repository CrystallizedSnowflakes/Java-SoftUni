package com.example.objectmapping.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"firstName", "last_name", "income"})
public class EmployeeDto extends BasicEmployeeDto{

    @Expose
    @SerializedName("salary")
    @XmlAttribute
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
