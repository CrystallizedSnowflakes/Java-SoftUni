package com.example.json_car_dealer.service;

import com.example.json_car_dealer.model.dto.LocalSupplierDto;
import com.example.json_car_dealer.model.entity.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    void seedData() throws IOException;

    Supplier getRandomSupplier();

    List<LocalSupplierDto> findLocalSuppliers();
}
