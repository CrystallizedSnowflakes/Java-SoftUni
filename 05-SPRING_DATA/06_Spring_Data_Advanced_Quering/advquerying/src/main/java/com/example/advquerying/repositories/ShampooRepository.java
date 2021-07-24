package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooRepository extends BaseRepository<Shampoo>{

    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    int countAllByPriceLessThan(BigDecimal price);

    // JPQL Querying
    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsNames(List<String> names);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i GROUP BY s.id HAVING COUNT(i) < :number")
     List<Shampoo> findAllByIngredientsCountLessThan(long number);
    /*@Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :number")
    List<Shampoo> findAllByIngredientsCountLessThan(int number);*/
}
