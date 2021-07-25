package com.example.json_car_dealer.model.dto;

import com.google.gson.annotations.Expose;

public class SoldCarDto {

    @Expose
    private String make;
    @Expose
    private String model;

    public SoldCarDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
