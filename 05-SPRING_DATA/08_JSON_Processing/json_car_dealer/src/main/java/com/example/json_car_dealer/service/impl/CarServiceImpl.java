package com.example.json_car_dealer.service.impl;

import com.example.json_car_dealer.model.dto.*;
import com.example.json_car_dealer.model.entity.Car;
import com.example.json_car_dealer.repository.CarRepository;
import com.example.json_car_dealer.service.CarService;
import com.example.json_car_dealer.service.PartService;
import com.example.json_car_dealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.json_car_dealer.constants.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
    }

    @Override
    public void seedData() throws IOException {

        if (this.carRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + FROM_CARS_FILE));

        CarSeedDto[] carSeedDTOs = this.gson
                .fromJson(fileContent, CarSeedDto[].class);

        List<Car> cars = Arrays.stream(carSeedDTOs)
                .filter(this.validationUtil::isValid)
                .map(carSeedDto -> {
                    Car car = this.modelMapper.map(carSeedDto, Car.class);
                    car.setParts(this.partService.getRandomParts());
                    return car;
                })
                .collect(Collectors.toList());
        cars.forEach(this.carRepository::save);
    }

    @Override
    public Car getRandomCar() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.carRepository.count() + 1);
        return this.carRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<ToyotaDto> findCarMakesToyota(String make) {
        return this.carRepository
                .findAllByMakeOrderByModelThenByTravelledDistanceDesc(make)
                .stream()
                .map(car -> this.modelMapper.map(car, ToyotaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarAndPartsDto> findCarsWithTheirParts() {
        List<Car> cars = this.carRepository.findAll();
        List<CarAndPartsDto> carAndPartsDTOs = cars
                .stream()
                .map(car -> {
                    CarAndPartsDto carAndPartsDto = new CarAndPartsDto();
                    carAndPartsDto.setCar(this.modelMapper.map(car, CarInfoDto.class));
                    carAndPartsDto.setParts(car.getParts()
                    .stream()
                    .map(part -> this.modelMapper.map(part, PartInfoDto.class))
                    .collect(Collectors.toSet()));
                    return carAndPartsDto;
                })
                .collect(Collectors.toList());
        return carAndPartsDTOs;
    }
}
