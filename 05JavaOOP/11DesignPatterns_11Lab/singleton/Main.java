package singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {

    /** Singleton Creational Design Pattern

     https://en.wikipedia.org/wiki/Singleton_pattern

     The singleton pattern restricts the instantiation of a class to one "single" instance.*/

    public static void main(String[] args) {
        Map<String, Integer> capitals = new HashMap<>();

        capitals.put("Sofia", 1284000);
        capitals.put("Vienna", 1945000);

        SingletonDataContainer instance = SingletonDataContainer.getInstance();
        System.out.println(instance.getPopulation(capitals, "Sofia"));
        System.out.println(instance.getPopulation(capitals, "Vienna"));

        SingletonDataContainer secondInstance = SingletonDataContainer.getInstance(); // point to the one and only instance
        System.out.println(secondInstance.getPopulation(capitals, "Sofia"));
        System.out.println(secondInstance.getPopulation(capitals, "Vienna"));
    }
}
