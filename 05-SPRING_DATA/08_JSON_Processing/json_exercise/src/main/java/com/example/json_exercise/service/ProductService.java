package com.example.json_exercise.service;

import com.example.json_exercise.model.dto.ProductWithSellerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductWithSellerDto> findAllProductsInRangeWithNoBuyerOrderByPrice(BigDecimal lower, BigDecimal upper);
}
