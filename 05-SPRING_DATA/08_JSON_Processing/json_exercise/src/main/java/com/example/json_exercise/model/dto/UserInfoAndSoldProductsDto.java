package com.example.json_exercise.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserInfoAndSoldProductsDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private SoldProductsCountAndProductsInfoDto soldProducts;

    public UserInfoAndSoldProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SoldProductsCountAndProductsInfoDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsCountAndProductsInfoDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
