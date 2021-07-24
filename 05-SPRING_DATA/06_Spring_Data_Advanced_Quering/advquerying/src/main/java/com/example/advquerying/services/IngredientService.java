package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<Ingredient> findAllByNameStartingWith(String name);
    List<Ingredient> findAllByNameIn(Collection<String> names);
    void deleteAllByName(String name);
    int updatePrice();
    List<Ingredient> findAll();
    int updatePrice(BigDecimal priceChange, Collection<String> names);
}
