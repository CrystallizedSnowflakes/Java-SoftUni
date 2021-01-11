package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05RoboticsMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = splitRobotsDataIntoLinkedHashMap(inputRobots);
        int[] workingTime = new int[robots.size()];

        String time = scanner.nextLine(); // hours:min:sec
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);
        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>(); //queue

        String product = scanner.nextLine();
        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()){
            // increase the totalTime with 1 sec
            totalTimeInSeconds++;
            String currentProduct = products.poll();
            // decrease the working time with 1 sec
            decreaseWorkingTime(workingTime);
            // iterate through the working time
            // all robots are checked
            if(!assignJob(robots, workingTime, currentProduct, totalTimeInSeconds)){ // true -> all robots are busy
                products.offer(currentProduct);
            }
        }
    }

    // iterate through the working time
    private static boolean assignJob(LinkedHashMap<String, Integer> robots, int[] workingTime, String currentProduct, long totalTimeInSeconds) {
        for (int i = 0; i < workingTime.length; i++) {
            if (workingTime[i] == 0){ //the robot is free for the next task
                int count = 0;
                for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                    if (count == i){
                        workingTime[i] = robot.getValue();
                        logJobAssigned(robot.getKey(), currentProduct, totalTimeInSeconds);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void logJobAssigned(String name, String product, long totalTimeInSeconds) {
        long hours = totalTimeInSeconds / 3600 % 24;
        long minutes = totalTimeInSeconds % 3600 / 60;
        long seconds = totalTimeInSeconds % 60;
        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", name, product, hours , minutes , seconds));
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

/*            String name = inputRobots[i].split("-")[0];
            int time = Integer.parseInt(inputRobots[i].split("-")[1]);*/

/*          String[] tokens = inputRobots[i].split("-");
            String name = tokens[0];
            int time = Integer.parseInt(tokens[1]);*/

            robots.put(name, time);
        }
        return robots;
    }
}
