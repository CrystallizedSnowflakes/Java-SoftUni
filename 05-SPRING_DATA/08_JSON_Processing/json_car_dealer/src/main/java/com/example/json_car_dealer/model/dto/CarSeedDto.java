package com.example.json_car_dealer.model.dto;

import com.example.json_car_dealer.model.entity.Car;
import com.example.json_car_dealer.model.entity.Part;
import com.google.gson.annotations.Expose;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class CarSeedDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public CarSeedDto() {
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

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
