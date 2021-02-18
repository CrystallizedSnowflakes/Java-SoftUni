package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (this.capacity > this.employees.size()){
            this.employees.add(employee);
        }
    }

    public boolean remove(String name){
        return this.employees.removeIf(employee -> employee.getName().equals(name));
//        int indexToRemove = -1;
//        for (int i = 0; i < employees.size(); i++) {
//            Employee employee = employees.get(i);
//            if (employee.getName().equals(name)){
//                indexToRemove = i;
//                break;
//            }
//        }
//
//        if (indexToRemove != -1){
//            employees.remove(indexToRemove);
//            return true;
//        }
//        return false;
    }

    public Employee getOldestEmployee(){
        //return this.employees.stream().min((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge())).orElse(null);
        Employee employee = null;
        for (Employee e : this.employees) {
            if (employee == null || employee.getAge() < e.getAge()){
                employee = e;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("Employees working at Bakery %s:", this.name));

        for (Employee employee : this.employees) {
            sb.append(System.lineSeparator());
            sb.append(employee.toString());
        }
        return sb.toString();
    }
}
