package com.example.json_car_dealer.repository;

import com.example.json_car_dealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByOrderByBirthDate();

    @Query("select c FROM Customer c WHERE size(c.sales) > 0")
    List<Customer> findAllCustomersOrderBySpentMoneyDescThenByBoughtCarsDesc();
}
