package e04TrafficLights2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight[] initialLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);
        int updates = Integer.parseInt(scanner.nextLine());

        TrafficLight[] lights = TrafficLight.values();

        StringBuilder sb = new StringBuilder();

        while (updates-- > 0){

            for (int i = 0; i < initialLights.length; i++) {
                int index = (initialLights[i].ordinal() + 1) % lights.length;
                initialLights[i] = lights[index];
                sb.append((initialLights[i])).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
