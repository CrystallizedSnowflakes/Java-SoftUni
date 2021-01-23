package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E09UserLogs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input;
        while (!"end".equals(input = scanner.nextLine())){
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, 0);
            int currentCount = users.get(user).get(ip);
            users.get(user).put(ip, currentCount + 1);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            System.out.println(user.getKey() + ":");

            LinkedHashMap<String, Integer> innerMap = user.getValue();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                String data = String.format("%s => %d, ", innerEntry.getKey(), innerEntry.getValue());
                sb.append(data);
            }
            //System.out.println(sb.toString());

            String output = sb.substring(0, sb.length() - 2) + ".";
            System.out.println(output);
        }
    }
}
