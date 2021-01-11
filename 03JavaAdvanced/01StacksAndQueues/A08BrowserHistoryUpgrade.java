package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>(); //stack
        ArrayDeque<String> forwardHistory = new ArrayDeque<>(); //queue

        String current = "";

        while (!navigation.equals("Home")) {

            switch (navigation){
                case "back":
                    if (!browserHistory.isEmpty()) {
                        forwardHistory.addFirst(current); //queue
                        current = browserHistory.pop(); //stack
                    } else {
                        System.out.println("no previous URLs");
                        navigation = scanner.nextLine();
                        continue;
                    }
                    break;
                case "forward":
                    if (!forwardHistory.isEmpty()) {
                        current = forwardHistory.poll(); //queue
                    } else {
                        System.out.println("no next URLs");
                        navigation = scanner.nextLine();
                        continue;
                    }
                    break;
                default:
                    if (!current.isEmpty()) {
                        browserHistory.push(current); //stack
                        forwardHistory.clear(); //queue
                    }
                    current = navigation;
                    break;
            }
            System.out.println(current);
            navigation = scanner.nextLine();
        }
    }
}
