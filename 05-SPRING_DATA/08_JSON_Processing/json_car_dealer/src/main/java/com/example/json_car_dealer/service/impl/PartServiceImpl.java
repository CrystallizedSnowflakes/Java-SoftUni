package com.example.json_car_dealer.service.impl;

import com.example.json_car_dealer.constants.GlobalConstants;
import com.example.json_car_dealer.model.dto.PartSeedDto;
import com.example.json_car_dealer.model.entity.Part;
import com.example.json_car_dealer.repository.PartRepository;
import com.example.json_car_dealer.service.PartService;
import com.example.json_car_dealer.service.SupplierService;
import com.example.json_car_dealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.json_car_dealer.constants.GlobalConstants.*;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }

    @Override
    public void seedData() throws IOException {
        if (partRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + FROM_PARTS_FILE));

        PartSeedDto[] partSeedDTOs = this.gson
                .fromJson(fileContent, PartSeedDto[].class);

        Arrays.stream(partSeedDTOs)
                .filter(validationUtil::isValid)
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        int count3to5Parts = ThreadLocalRandom.current().nextInt(3, 6);
        long allPartsInDB = this.partRepository.count();
        for (int i = 0; i < count3to5Parts; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, allPartsInDB + 1);
            boolean isIdExists = parts.stream().anyMatch(part -> part.getId().equals(randomId));
            if (isIdExists){
                continue;
            }
            parts.add(this.partRepository.findById(randomId).orElse(null));
        }
        return parts;
    }
}
