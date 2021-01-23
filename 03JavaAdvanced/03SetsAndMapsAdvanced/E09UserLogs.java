package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, 0);
            int currentCount = users.get(user).get(ip);
            users.get(user).put(ip, currentCount + 1);

            input = scanner.nextLine();
        }

       for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            System.out.println(user.getKey() + ":");

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                String data = String.format("%s => %d, ", entry.getKey(), entry.getValue());
                sb.append(data);
            }
            String output = sb.substring(0, sb.length() - 2) + ".";
            System.out.println(output);
        }
    }
}
