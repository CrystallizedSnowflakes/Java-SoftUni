package com.example.objectmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
- "find X" -> return JSON with info about the Manager and his subordinates ( x = id)
- "findAll" -> return Array JSON with info about the Manager and his subordinates
- "save {firstName: "...", lastName: "...", salary: "xxxx.x", address: "..."}" - save in DB & return this + id
save {"firstName": "New", "lastName": "Employee", "salary": 3000.50, "address": "Mladost"}
save {firstName: "New", lastName: "Employee", salary: 3000.50, address: "Mladost"}
- "save-from-file (filePath)" - read JSON file and save it to DB
save-from-file ./src/main/resources/first-employee.json
- "findAll-to (filePath) - save all managers in a file
*/


@SpringBootApplication
public class ObjectMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjectMappingApplication.class, args);
    }

}
