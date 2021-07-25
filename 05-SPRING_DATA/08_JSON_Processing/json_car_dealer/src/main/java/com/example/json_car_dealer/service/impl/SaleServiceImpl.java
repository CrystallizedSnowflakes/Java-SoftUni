package com.example.json_car_dealer.service.impl;

import com.example.json_car_dealer.model.dto.CarInfoDto;
import com.example.json_car_dealer.model.dto.SaleWithDiscountDto;
import com.example.json_car_dealer.model.entity.Car;
import com.example.json_car_dealer.model.entity.Customer;
import com.example.json_car_dealer.model.entity.Part;
import com.example.json_car_dealer.model.entity.Sale;
import com.example.json_car_dealer.repository.SaleRepository;
import com.example.json_car_dealer.service.CarService;
import com.example.json_car_dealer.service.CustomerService;
import com.example.json_car_dealer.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData() {

        if (this.saleRepository.count() > 0){
            return;
        }

        for (long i = 0; i < 20; i++) {
            Sale sale = new Sale();
            BigDecimal[] discounts = new BigDecimal[]{
                    BigDecimal.valueOf(0.05),
                    BigDecimal.valueOf(0.10),
                    BigDecimal.valueOf(0.15),
                    BigDecimal.valueOf(0.20),
                    BigDecimal.valueOf(0.30),
                    BigDecimal.valueOf(0.40),
                    BigDecimal.valueOf(0.50),
            };
            int random = ThreadLocalRandom.current().nextInt(0, discounts.length);
            BigDecimal discount = discounts[random];
            Customer customer = customerService.getRandomCustomer();
            if (customer.isYoungDriver()){
                sale.setDiscount(discount.add(BigDecimal.valueOf(0.05)));
            }else {
                sale.setDiscount(discount);
            }
            Car car = carService.getRandomCar();
            sale.setCar(car);
            sale.setCustomer(customer);
            saleRepository.save(sale);
        }
    }

    @Override
    public List<SaleWithDiscountDto> findSalesWithAppliedDiscount() {

        List<Sale> sales = this.saleRepository.findAll();
        return sales
                .stream()
                .map(sale -> {
                    SaleWithDiscountDto dto = this.modelMapper.map(sale, SaleWithDiscountDto.class);
                    dto.setPrice(sale.getCar().getParts()
                        .stream().map(Part::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
                    dto.setPriceWithDiscount(dto.getPrice().subtract(dto.getPrice().multiply(sale.getDiscount())));
                return dto;
                }).collect(Collectors.toList());
    }
}
