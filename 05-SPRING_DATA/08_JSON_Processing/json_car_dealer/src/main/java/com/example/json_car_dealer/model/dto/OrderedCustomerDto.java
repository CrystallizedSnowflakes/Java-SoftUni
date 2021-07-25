package com.example.json_car_dealer.model.dto;


import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderedCustomerDto {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungerDriver;
    @Expose
    private Set<SoldCarDto> sales;

    public OrderedCustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungerDriver() {
        return isYoungerDriver;
    }

    public void setYoungerDriver(boolean youngerDriver) {
        isYoungerDriver = youngerDriver;
    }

    public Set<SoldCarDto> getSales() {
        return sales;
    }

    public void setSales(Set<SoldCarDto> sales) {
        this.sales = sales;
    }
}
