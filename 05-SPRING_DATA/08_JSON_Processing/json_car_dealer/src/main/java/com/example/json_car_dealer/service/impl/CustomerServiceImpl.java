package com.example.json_car_dealer.service.impl;

import com.example.json_car_dealer.model.dto.CustomerAndBoughtCarsDto;
import com.example.json_car_dealer.model.dto.CustomerSeedDto;
import com.example.json_car_dealer.model.dto.OrderedCustomerDto;
import com.example.json_car_dealer.model.dto.SoldCarDto;
import com.example.json_car_dealer.model.entity.Customer;
import com.example.json_car_dealer.model.entity.Part;
import com.example.json_car_dealer.model.entity.Sale;
import com.example.json_car_dealer.repository.CustomerRepository;
import com.example.json_car_dealer.service.CustomerService;
import com.example.json_car_dealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.json_car_dealer.constants.GlobalConstants.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override

    public void seedData() throws IOException {

        if (this.customerRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + FROM_CUSTOMERS_FILE));

        CustomerSeedDto[] customerSeedDTOs = this.gson
                .fromJson(fileContent, CustomerSeedDto[].class);

        Arrays.stream(customerSeedDTOs)
                .filter(validationUtil::isValid)
                .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                .forEach(this.customerRepository::save);

    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.customerRepository.count() + 1);
        return this.customerRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<OrderedCustomerDto> findOrderedCustomers() {
        List<OrderedCustomerDto> orderedCustomerDTOs = this.customerRepository.findAllByOrderByBirthDate()
                .stream()
                .map(customer -> {
                    OrderedCustomerDto dto = this.modelMapper.map(customer, OrderedCustomerDto.class);
                    Set<SoldCarDto> soldCarDTOs = customer.getSales()
                            .stream()
                            .map(sale -> {
                                SoldCarDto soldCarDto = this.modelMapper.map(sale, SoldCarDto.class);
                                soldCarDto.setMake(sale.getCar().getMake());
                                soldCarDto.setModel(sale.getCar().getModel());
                                return soldCarDto;
                            })
                            .collect(Collectors.toSet());
                    dto.setSales(soldCarDTOs);
                    return dto;
                })
                .sorted(Comparator.comparing(OrderedCustomerDto::isYoungerDriver))
                .collect(Collectors.toList());
        return orderedCustomerDTOs;
    }

    @Override
    public List<CustomerAndBoughtCarsDto> findCustomerSales() {

        List<Customer> customers = this.customerRepository.findAllCustomersOrderBySpentMoneyDescThenByBoughtCarsDesc();

        return customers
                .stream()
                .map(customer -> {
                    CustomerAndBoughtCarsDto dto = this.modelMapper.map(customer, CustomerAndBoughtCarsDto.class);
                    Set<Sale> sales = customer.getSales();
                    dto.setBoughtCars(sales.size());

                    BigDecimal spentMoney = sales
                            .stream()
                            .map(sale -> sale.getCar().getParts()
                                    .stream()
                                    .map(Part::getPrice)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                            )
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    dto.setSpentMoney(spentMoney);
                    return dto;
                })
                .sorted((c1, c2) -> {
                    int result = c2.getSpentMoney().compareTo(c1.getSpentMoney());
                    if (result == 0){
                        result = c2.getBoughtCars().compareTo(c1.getBoughtCars());
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }
}
