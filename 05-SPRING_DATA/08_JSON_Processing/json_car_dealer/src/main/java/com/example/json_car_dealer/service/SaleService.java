package com.example.json_car_dealer.service;

import com.example.json_car_dealer.model.dto.SaleWithDiscountDto;

import java.util.List;

public interface SaleService {

    void seedData();

    List<SaleWithDiscountDto> findSalesWithAppliedDiscount();
}
