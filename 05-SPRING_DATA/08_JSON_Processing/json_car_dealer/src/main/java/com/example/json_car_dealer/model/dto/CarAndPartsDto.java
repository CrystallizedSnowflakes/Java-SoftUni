package com.example.json_car_dealer.model.dto;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

public class CarAndPartsDto {

    @Expose
    private CarInfoDto car;
    @Expose
    private Set<PartInfoDto> parts;

    public CarAndPartsDto() {
        this.parts = new HashSet<>();
    }

    public CarInfoDto getCar() {
        return car;
    }

    public void setCar(CarInfoDto car) {
        this.car = car;
    }

    public Set<PartInfoDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartInfoDto> parts) {
        this.parts = parts;
    }
}
