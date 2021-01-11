package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08SimpleTextEditorStringBuilder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());;

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> sbHistory = new ArrayDeque<>();

        while (numberOfOperations-- > 0){
            String[] inputParams = scanner.nextLine().split("\\s+");
            String command = inputParams[0];
            String value = (inputParams.length > 1) ? inputParams[1] : null;

            switch (command){
                // appends value to the end of the text
                case "1":
                    sbHistory.push(sb.toString());
                    sb.append(value);
                    break;

                // erases the last number(value) of elements from the text
                case "2":
                    sbHistory.push(sb.toString());
                    assert value != null;
                    int startIndex = sb.length() - Integer.parseInt(value);
                    int endIndexExclusive = sb.length();
                    sb.delete(startIndex, endIndexExclusive);
                    break;

                // returns the element at position index(value) from the text
                case "3":
                    assert value != null;
                    System.out.println(sb.charAt(Integer.parseInt(value) - 1));
                    break;

                // undoes the last not undone command of type 1 / 2
                // and returns the text to the state before that operation
                case "4":
                    sb = new StringBuilder(sbHistory.pop());
                    break;
            }
        }
    }
}
