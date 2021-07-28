package com.example.json_car_dealer.service.impl;

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
            List<Double> discounts = List.of(0.05, 0.1, 0.2, 0.3, 0.4, 0.5);
            int random = ThreadLocalRandom.current().nextInt(discounts.size());
            Double discount = discounts.get(random);

            Sale sale = new Sale();
            Customer customer = customerService.getRandomCustomer();
            if (customer.isYoungDriver()){
                sale.setDiscount(BigDecimal.valueOf(discount).add(BigDecimal.valueOf(0.05)));
            }else {
                sale.setDiscount(BigDecimal.valueOf(discount));
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
