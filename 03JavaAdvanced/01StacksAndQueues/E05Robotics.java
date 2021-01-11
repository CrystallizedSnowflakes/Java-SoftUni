package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = getLinkedHashMap(inputRobots);
        String time = scanner.nextLine(); // hours:min:sec
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);
        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        int[] workingTime = new int[robots.size()];

        String product = scanner.nextLine();
        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()){
            String currentProduct = products.poll();
            // increase the totalTime with 1 sec
            totalTimeInSeconds++;
            boolean isAssigned = false;
            // decrease the working time with 1 sec
            for (int robot = 0; robot < workingTime.length; robot++) {
                if (workingTime[robot] > 0){
                    --workingTime[robot];
                }
            }
            // iterate through the working time
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0){ //the robot is free for the next task
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i){
                            workingTime[i] = robot.getValue();
                            // totalTimeInSeconds = hours, minutes, seconds
                            long takenHours = totalTimeInSeconds / 3600 % 24;
                            long takenMinutes = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;

                            System.out.printf("%s - %s [%02d:%02d:%02d]%n",
                                    robot.getKey(), currentProduct, takenHours, takenMinutes, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            // all robots are checked
            if (!isAssigned){ // true -> all robots are busy
                products.offer(currentProduct);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getLinkedHashMap(String[] inputRobots) {

        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobots.length; i++) {
/*          String[] tokens = inputRobots[i].split("-");
            String name = tokens[0];
            int time = Integer.parseInt(tokens[1]);*/

            String name = inputRobots[i].split("-")[0];
            int time = Integer.parseInt(inputRobots[i].split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
