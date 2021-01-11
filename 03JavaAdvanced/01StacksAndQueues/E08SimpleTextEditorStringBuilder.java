package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08SimpleTextEditorStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(sb.toString());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command){
                case "1":
                    String stringToAppend = tokens[1];
                    sb.append(stringToAppend);
                    stack.push(sb.toString());
                    break;
                case "2":
                    int countOfLastElementToDelete = Integer.parseInt(tokens[1]);
                    int startIndex = sb.length() - countOfLastElementToDelete;
                    int endIndexExclusive = sb.length();
                    sb.delete(startIndex, endIndexExclusive);
                    stack.push(sb.toString());
                    break;
                case  "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    sb = new StringBuilder();
                    sb.append(stack.peek());
                    break;
                default:
                    System.out.println("The command is invalid " + command);
                    break;
            }
        }
    }
}
