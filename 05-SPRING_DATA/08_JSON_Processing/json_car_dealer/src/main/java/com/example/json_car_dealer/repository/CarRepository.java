package com.example.json_car_dealer.repository;

import com.example.json_car_dealer.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c " +
            "WHERE c.make = :make " +
            "ORDER BY c.model, c.travelledDistance DESC")
    List<Car> findAllByMakeOrderByModelThenByTravelledDistanceDesc(String make);

}
