package bg.softuni.javaadvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(name, new TreeMap<>());
            Integer currentDuration = users.get(name).get(ip);
            if (currentDuration == null){
                currentDuration = 0;
            }
            users.get(name).put(ip, currentDuration + duration);
        }


        for (Map.Entry<String, TreeMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%s: %d [", user.getKey(), sum);

            StringBuilder line = new StringBuilder();
            for (Map.Entry<String, Integer> userIP : user.getValue().entrySet()) {
                String data = String.format("%s, ", userIP.getKey());
                line.append(data);
            }
            String output = line.substring(0, line.length() - 2) + "]";
            System.out.println(output);
        }
    }
}
