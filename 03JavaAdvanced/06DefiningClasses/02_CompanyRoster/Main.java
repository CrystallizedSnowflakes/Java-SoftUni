package companyRoster_02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // departmentName -> DEPARTMENT (departmentName, employees)
        HashMap<String, Department> departments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee employee;
            if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (input.length == 4){
                employee = new Employee(name, salary, position, department);
            } else { // input.length == 5
                try{
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e){
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.putIfAbsent(department,new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        // departmentName -> DEPARTMENT (departmentName, employees)
        Department maxAverageDepartmentSalary = departments.entrySet()
                .stream()
                // -> DEPARTMENT (departmentName, employees)
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageEmployeesSalary()))
                // returns map departments
                .get()
                // we get only the value
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", maxAverageDepartmentSalary.getName());
        maxAverageDepartmentSalary.getEmployees()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
