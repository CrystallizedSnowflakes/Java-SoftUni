package com.example.json_car_dealer.model.dto;

import com.google.gson.annotations.Expose;

public class ToyotaDto {

    @Expose
    private Long id;
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public ToyotaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
