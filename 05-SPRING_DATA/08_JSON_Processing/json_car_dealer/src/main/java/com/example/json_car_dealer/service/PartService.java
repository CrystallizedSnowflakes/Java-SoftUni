package com.example.json_car_dealer.service;

import com.example.json_car_dealer.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {

    void seedData() throws IOException;

    Set<Part> getRandomParts();
}
