package e04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialTrafficLightsStates = scanner.nextLine().split("\\s+");
        int numberOfUpdates = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialState : initialTrafficLightsStates) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightsState.valueOf(initialState));
            trafficLights.add(trafficLight);
        }

        while (numberOfUpdates-- > 0){
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println();
        }
    }
}
