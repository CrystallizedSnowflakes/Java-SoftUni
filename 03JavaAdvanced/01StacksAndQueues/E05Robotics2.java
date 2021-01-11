package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E05Robotics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(";");

        int[] time = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();

        int startTime = time[0] * 3600 + time[1] * 60 + time[2];

        String[] robotNames = new String[inputData.length];
        int[] robotTime = new int[inputData.length];
        int[] robotCurrentTime = new int[robotTime.length];

        for (int i = 0; i < inputData.length; i++) {
            String[] tokens = inputData[i].split("-");
            robotNames[i] = tokens[0];
            robotTime[i] = Integer.parseInt(tokens[1]);
        }
        Deque<String> queue = new ArrayDeque<>();
        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            queue.offer(input);
        }

        while (!queue.isEmpty()) {
            startTime++;
            String product = queue.poll();
            boolean allBusy = true;
            for (int i = 0; i < robotCurrentTime.length; i++) {
                if (robotCurrentTime[i] != 0) {
                    --robotCurrentTime[i];
                }
            }
            for (int i = 0; i < robotNames.length; i++) {
                if (robotCurrentTime[i] == 0) {
                    robotCurrentTime[i] = robotTime[i];
                    int hour = (startTime / 3600) % 24;
                    int minute = (startTime / 60) % 60;
                    int seconds = startTime % 60;
                    System.out.printf("%s - %s [%s]%n", robotNames[i], product,
                            String.format("%02d:%02d:%02d", hour, minute, seconds));
                    allBusy = false;
                    break;
                }

            }
            if (allBusy) {
                queue.offer(product);
            }
        }
    }
}
