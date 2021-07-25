package com.example.json_car_dealer.service.impl;

import com.example.json_car_dealer.model.dto.LocalSupplierDto;
import com.example.json_car_dealer.model.dto.SupplierSeedDto;
import com.example.json_car_dealer.model.entity.Supplier;
import com.example.json_car_dealer.repository.SupplierRepository;
import com.example.json_car_dealer.service.SupplierService;
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
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException {

        if (this.supplierRepository.count() > 0){
            return;
        }
        // read data
        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + FROM_SUPPLIERS_FILE));
        // from JSON to Array
        SupplierSeedDto[] supplierSeedDTOs = this.gson
                .fromJson(fileContent, SupplierSeedDto[].class);
        // save in DB
        Arrays.stream(supplierSeedDTOs)
                .filter(this.validationUtil::isValid)
                .map(supplierSeedDto -> this.modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(this.supplierRepository::save);
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.supplierRepository.count() + 1);
        return this.supplierRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<LocalSupplierDto> findLocalSuppliers() {
        return this.supplierRepository.findAllByImporterFalse()
                .stream()
                .map(supplier -> {
                    LocalSupplierDto localSupplierDto = this.modelMapper.map(supplier, LocalSupplierDto.class);
                    localSupplierDto.setPartsCount(supplier.getParts().size());
                    return localSupplierDto;
                })
                .collect(Collectors.toList());
    }
}
