package com.example.json_car_dealer.service;

import com.example.json_car_dealer.model.dto.CustomerAndBoughtCarsDto;
import com.example.json_car_dealer.model.dto.OrderedCustomerDto;
import com.example.json_car_dealer.model.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedData() throws IOException;

    Customer getRandomCustomer();

    List<OrderedCustomerDto> findOrderedCustomers();

    List<CustomerAndBoughtCarsDto> findCustomerSales();
}
