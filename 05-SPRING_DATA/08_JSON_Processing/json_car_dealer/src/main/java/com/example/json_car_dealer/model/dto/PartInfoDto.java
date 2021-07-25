package com.example.json_car_dealer.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PartInfoDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public PartInfoDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
