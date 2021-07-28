package com.example.xmlex.service;

import com.example.xmlex.model.dto.seed.ProductSeedDto;
import com.example.xmlex.model.dto.inRange.ProductViewRootDto;

import java.util.List;

public interface ProductService {

    long getEntityCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithNoBuyer();
}
