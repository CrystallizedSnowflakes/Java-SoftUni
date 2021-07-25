package com.example.json_exercise.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class SoldProductsCountAndProductsInfoDto {

    @Expose
    private Integer count;
    @Expose
    private Set<SoldProductNameAndPriceDto> products;

    public SoldProductsCountAndProductsInfoDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<SoldProductNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(Set<SoldProductNameAndPriceDto> products) {
        this.products = products;
    }
}
