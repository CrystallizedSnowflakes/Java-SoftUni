package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08SimpleTextEditorString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String str = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(str);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    String stringToAppend = tokens[1];
                    str += stringToAppend;
                    stack.push(str);
                    break;
                case "2":
                    int countOfLastElementToDelete = Integer.parseInt(tokens[1]);
                    int startIndex = str.length() - countOfLastElementToDelete;
                    str = str.substring(0, startIndex);
                    stack.push(str);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(str.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    str = stack.peek();
                    break;
                default:
                    System.out.println("The command is invalid " + tokens[0]);
                    break;
            }
        }
    }
}
