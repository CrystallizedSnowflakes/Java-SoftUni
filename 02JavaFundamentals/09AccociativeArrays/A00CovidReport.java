package bg.softuni.javafundamentals;

import java.util.HashMap;
import java.util.Map;

public class A00CovidReport {
    public static void main(String[] args) {
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
         */

        Map<String, Integer> infectedByCity = new HashMap<>();
        infectedByCity.put("Gabrovo", 15); // put / if it exist - create or override on position "Gabrovo" -> 15
        infectedByCity.put("Gabrovo", 30); // = set prezapisva
        // we want to have 45
        int firstDay = 15;
        int secondDay = 30;
        Integer current = infectedByCity.get("Gabrovo");
        // null point exception
        if (current == null){
            current = 0;
        }
        infectedByCity.put("Gabrovo", current + firstDay);
        current = infectedByCity.get("Gabrovo");
        if (current == null){
            current = 0;
        }
        infectedByCity.put("Gabrovo", current + secondDay);

        infectedByCity.put("Sofia", 13); // = set prezapisva


        System.out.println(infectedByCity.get("Gabrovo")); // give me by key "Gabrovo"
        System.out.println(infectedByCity.get("Sofia")); // give me by key "Gabrovo"


    }
}
