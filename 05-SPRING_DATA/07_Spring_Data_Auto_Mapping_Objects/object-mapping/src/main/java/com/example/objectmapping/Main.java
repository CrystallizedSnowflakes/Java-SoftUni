package com.example.objectmapping;

import com.example.objectmapping.models.dto.EmployeeDto;
import com.example.objectmapping.models.dto.ManagerDto;
import com.example.objectmapping.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        //ManagerDto managerDto = this.employeeService.findOne(1L);
        List<ManagerDto> managers = this.employeeService.findAll();
        managers.forEach(managerDto -> {
            System.out.printf("%s %s : (%d)%n",
                    managerDto.getFirstName(),
                    managerDto.getLastName(),
                    managerDto.getSubordinates().size());
            managerDto.getSubordinates().forEach(employeeDto -> {
                System.out.printf("\t %s %s : %.2f%n",
                        employeeDto.getFirstName(),
                        employeeDto.getLastName(),
                        employeeDto.getIncome());
            });
        });
    }
}
