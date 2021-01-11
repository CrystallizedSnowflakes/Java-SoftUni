package bg.softuni.javaadvanced;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05RoboticsLocalTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = splitRobotsDataIntoLinkedHashMap(inputRobots);
        int[] workingTime = new int[robots.size()];

        String inputTime = scanner.nextLine();
        if (inputTime.length() == 7){
            inputTime = "0" + inputTime;
        }
        LocalTime time = LocalTime.parse(inputTime); // 08:00:00

        ArrayDeque<String> products = new ArrayDeque<>(); //queue

        String product = scanner.nextLine();
        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()){
            // increase the totalTime with 1 sec
            time = time.plusSeconds(1);
            String currentProduct = products.poll();
            // decrease the working time with 1 sec
            decreaseWorkingTime(workingTime);
            // iterate through the working time
            // all robots are checked
            if(!assignJob(robots, workingTime, currentProduct, time)){ // true -> all robots are busy
                products.offer(currentProduct);
            }
        }
    }

    // iterate through the working time
    private static boolean assignJob(LinkedHashMap<String, Integer> robots, int[] workingTime, String currentProduct, LocalTime time) {
        for (int i = 0; i < workingTime.length; i++) {
            if (workingTime[i] == 0){ //the robot is free for the next task
                int count = 0;
                for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                    if (count == i){
                        workingTime[i] = robot.getValue();
                        logJobAssigned(robot.getKey(), currentProduct, time);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void logJobAssigned(String name, String product, LocalTime time) {
        String format = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(String.format("%s - %s [%s]", name, product, format));
    }

    private static void decreaseWorkingTime(int[] workingTime) {
        for (int robot = 0; robot < workingTime.length; robot++) {
            if (workingTime[robot] > 0){
                --workingTime[robot];
            }
        }
    }

    private static LinkedHashMap<String, Integer> splitRobotsDataIntoLinkedHashMap(String[] inputRobots) {

        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobots.length; i++) {
            String line = inputRobots[i];
            int index = line.indexOf("-");
            String name = line.substring(0, index);
            int time = Integer.parseInt(line.substring(index + 1));
            robots.put(name, time);
        }
        return robots;
    }
}
