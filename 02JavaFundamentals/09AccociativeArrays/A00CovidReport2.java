package bg.softuni.javafundamentals;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A00CovidReport2 {
    public static void main(String[] args) {

        // Associative Arrays

/*
Gabrovo 15
Sofia 55
Plovdiv 19
Stara_Zagora 42
Sofia 40
Plovdiv 5
Gabrovo 30
report Gabrovo
report Sofia
Gabrovo 4
report Gabrovo
end
---
45
95
49
---
Gabrovo -> 45
Sofia -> 95
Plovdiv -> 49
*/
        Map<String, Integer> infectedByCity = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();
        while (!command.equals("end")){
            if (command.equals("report")){
                String cityName = scanner.next();
                System.out.println(infectedByCity.get(cityName));
            } else {
                int newlyInfected = scanner.nextInt();
                Integer currentInfected = infectedByCity.get(command);
                if (currentInfected == null){
                    currentInfected = 0;
                }
                infectedByCity.put(command, currentInfected + newlyInfected);
            }
            command = scanner.next();
        }

        for (Map.Entry<String, Integer> entry : infectedByCity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
