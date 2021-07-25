package com.example.json_car_dealer.service;

import com.example.json_car_dealer.model.dto.CarAndPartsDto;
import com.example.json_car_dealer.model.dto.ToyotaDto;
import com.example.json_car_dealer.model.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {

    void seedData() throws IOException;

    Car getRandomCar();

    List<ToyotaDto> findCarMakesToyota(String toyota);

    List<CarAndPartsDto> findCarsWithTheirParts();
}
