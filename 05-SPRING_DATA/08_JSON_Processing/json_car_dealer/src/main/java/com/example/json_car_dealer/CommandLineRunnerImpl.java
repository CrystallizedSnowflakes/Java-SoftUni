package com.example.json_car_dealer;

import com.example.json_car_dealer.model.dto.*;
import com.example.json_car_dealer.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.example.json_car_dealer.constants.GlobalConstants.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

        while (true) {
            System.out.println("Please Enter Query from 1 to 6:");
            int query = Integer.parseInt(bufferedReader.readLine());
            switch (query) {
                case 1 -> orderedCustomers();
                case 2 -> carsFromMakeToyota();
                case 3 -> localSuppliers();
                case 4 -> carsAndParts();
                case 5 -> customerTotalSales();
                case 6 -> salesWithAppliedDiscount();
                default -> System.err.println("Invalid query number.");
            }
        }
    }

    private void salesWithAppliedDiscount() throws IOException {
        List<SaleWithDiscountDto> saleWithDiscountDTOs = this.saleService.findSalesWithAppliedDiscount();
        String content = gson.toJson(saleWithDiscountDTOs);
        writeToFile(TO_SALES_DISCOUNT_FILE, content);
    }

    private void customerTotalSales() throws IOException {
        List<CustomerAndBoughtCarsDto> customerAndBoughtCarsDTOs = this.customerService.findCustomerSales();
        String content = gson.toJson(customerAndBoughtCarsDTOs);
        writeToFile(TO_CUSTOMER_SALES_FILE, content);
    }

    private void carsAndParts() throws IOException {
        List<CarAndPartsDto> carAndPartsDTOs = this.carService.findCarsWithTheirParts();
        String content = gson.toJson(carAndPartsDTOs);
        writeToFile(TO_CAR_AND_PARTS_FILE, content);
    }

    private void localSuppliers() throws IOException {
        List<LocalSupplierDto> localSupplierDTOs = this.supplierService.findLocalSuppliers();
        String content = gson.toJson(localSupplierDTOs);
        writeToFile(TO_LOCAL_SUPPLIER_FILE, content);
    }

    private void carsFromMakeToyota() throws IOException {
        List<ToyotaDto> toyotaDTOs = this.carService.findCarMakesToyota("Toyota");
        String content = gson.toJson(toyotaDTOs);
        writeToFile(TO_TOYOTA_FILE, content);

    }

    private void orderedCustomers() throws IOException {
        List<OrderedCustomerDto> orderedCustomerDTOs = this.customerService.findOrderedCustomers();
        String content = gson.toJson(orderedCustomerDTOs);
        writeToFile(TO_ORDERED_CUSTOMERS_FILE, content);
    }

    private void writeToFile(String fileName, String content) throws IOException {
        Files
                .write(Path.of(OUTPUT_FILE_PATH + fileName),
                        Collections.singleton(content));
    }

    private void seedData() throws IOException {
        this.supplierService.seedData();
        this.partService.seedData();
        this.carService.seedData();
        this.customerService.seedData();
        this.saleService.seedData();
    }
}
