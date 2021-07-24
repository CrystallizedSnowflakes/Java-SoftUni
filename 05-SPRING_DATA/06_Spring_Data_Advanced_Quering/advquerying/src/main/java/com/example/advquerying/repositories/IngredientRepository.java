package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends BaseRepository<Ingredient> {

    List<Ingredient> findAllByNameStartingWith(String name);
    List<Ingredient> findAllByNameIn(Collection<String> names);

    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    @Modifying
    void deleteAllByName(String name);

    @Query("UPDATE Ingredient SET price = price * 1.1")
    @Modifying
    int updatePrice();

    @Query("UPDATE Ingredient SET price = price * :priceChange WHERE name IN :names")
    @Modifying
    int updatePrice(BigDecimal priceChange, Collection<String> names);
}
