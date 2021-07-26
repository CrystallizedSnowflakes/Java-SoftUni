package com.example.objectmapping;

import com.example.objectmapping.models.dto.EmployeeCreateRequestDto;
import com.example.objectmapping.models.dto.EmployeeCreateResponseDto;
import com.example.objectmapping.models.dto.ManagerCollection;
import com.example.objectmapping.models.dto.ManagerDto;
import com.example.objectmapping.services.EmployeeService;
import com.example.objectmapping.services.util.FormatConverter;
import com.example.objectmapping.services.util.FormatConvertorFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final FormatConvertorFactory factory;

    public Main(EmployeeService employeeService, FormatConvertorFactory factory) {
        this.employeeService = employeeService;
        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter format type 'json' or 'xml':");

        String formatType = sc.nextLine();
        FormatConverter converter = this.factory.create(formatType);
        converter.setPrettyPrint();

        String line = sc.nextLine();
        while (!line.equals("end")){

            String[] cmdParts = line.split(" ", 2);

            switch (cmdParts[0]){
                case "find":
                    // test: find 1
                    Long id = Long.parseLong(cmdParts[1]);
                    ManagerDto managerById = this.employeeService.findOne(id);
                    System.out.println(converter.serialize(managerById));
                    break;
                case "findAll":
                    // test: findAll
                    List<ManagerDto> allManagers = this.employeeService.findAll();
                    System.out.println(converter.serialize(new ManagerCollection(allManagers)));
                    break;
                case "save":
                    // test: save {"salary": 2200.50, "address": "Center", "firstName": "New", "lastName": "Employee from File"}
                    // test: save <?xml version="1.0" encoding="UTF-8" standalone="yes"?><employee first_name="Ot" last_name="XML :)"><salary>2000</salary><address>Mladost 4</address></employee>

                    String input = cmdParts[1];
                    EmployeeCreateRequestDto requestDto = converter.deserialize(input, EmployeeCreateRequestDto.class);
                    EmployeeCreateResponseDto responseDto = this.employeeService.save(requestDto);
                    System.out.println(converter.serialize(responseDto));
                    break;
                case "save-from-file":
                    // test: save-from-file ./src/main/resources/some-employee

                    EmployeeCreateRequestDto fileRequest = converter
                            .deserializeFromFile(cmdParts[1] + "." + formatType, EmployeeCreateRequestDto.class);
                    EmployeeCreateResponseDto fileResponseDto = this.employeeService.save(fileRequest);
                    System.out.println(converter.serialize(fileResponseDto));
                    break;
                case "findAll-to":
                    // test: findAll-to ./src/main/resources/findAll-second

                    List<ManagerDto> managers = this.employeeService.findAll();
                    converter.serialize(new ManagerCollection(managers), cmdParts[1] + "." + formatType);
                    System.out.println("Written to file " + cmdParts[1] + "." + formatType);
                    break;
                case "change-format":
                    converter = this.factory.create(cmdParts[1]);
                    converter.setPrettyPrint();
                    System.out.println("Changed to " + cmdParts[1]);
                    break;
                default:
                    System.out.println("Unexpected value: " + cmdParts[0]);
            }
            line = sc.nextLine();
        }
    }
}
