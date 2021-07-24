package com.example.objectmapping;

import com.example.objectmapping.models.dto.EmployeeCreateRequestDto;
import com.example.objectmapping.models.dto.EmployeeCreateResponseDto;
import com.example.objectmapping.models.dto.ManagerDto;
import com.example.objectmapping.services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final Gson gson;

    public Main(EmployeeService employeeService, Gson gson) {
        this.employeeService = employeeService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.equals("end")){
            String[] cmdParts = line.split(" ", 2);
            switch (cmdParts[0]){
                case "find":
                    Long id = Long.parseLong(cmdParts[1]);
                    ManagerDto managerById = this.employeeService.findOne(id);
                    String result = this.gson.toJson(managerById);
                    System.out.println(result);
                    break;
                case "findAll":
                    List<ManagerDto> allManagers = this.employeeService.findAll();
                    result = this.gson.toJson(allManagers);
                    System.out.println(result);
                    break;
                case "save":
                    String json = cmdParts[1];
                    EmployeeCreateRequestDto requestDto = this.gson.fromJson(json, EmployeeCreateRequestDto.class);
                    EmployeeCreateResponseDto responseDto = this.employeeService.save(requestDto);
                    result = this.gson.toJson(responseDto);
                    System.out.println(result);
                    break;
                case "save-from-file":
                    requestDto = this.gson.fromJson(new FileReader(cmdParts[1]), EmployeeCreateRequestDto.class);
                    responseDto = this.employeeService.save(requestDto);
                    result = this.gson.toJson(responseDto);
                    System.out.println(result);
                    break;

                case "findAll-to":
                    /*List<ManagerDto> managers = this.employeeService.findAll();
                    FileWriter fileWriter = new FileWriter("./src/main/resources/findAll-first.json");
                    this.gson.toJson(managers, fileWriter);
                    //fileWriter.flush();
                    fileWriter.close();
                    System.out.println("Written to file ./src/main/resources/findAll-first.json");*/

                    try(FileWriter fileWriter = new FileWriter("./src/main/resources/findAll-second.txt")){
                        List<ManagerDto> managers = this.employeeService.findAll();
                        this.gson.toJson(managers, fileWriter);
                        System.out.println("Written to file ./src/main/resources/findAll-second.txt");
                    }
                    break;

            }


            line = sc.nextLine();
        }


/*    //ManagerDto managerDto = this.employeeService.findOne(1L);
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
    });*/
    }
}
