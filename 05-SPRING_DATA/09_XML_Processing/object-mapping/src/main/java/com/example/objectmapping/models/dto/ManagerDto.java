package com.example.objectmapping.models.dto;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerDto extends BasicEmployeeDto{

    @Expose
    @XmlElementWrapper
    @XmlElement(name = "employee")
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
