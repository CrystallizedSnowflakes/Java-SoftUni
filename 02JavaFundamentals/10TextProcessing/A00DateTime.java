package bg.softuni.javafundamentals;

import java.util.Date;

public class A00DateTime {
    public static void main(String[] args) {
        Date start = new Date();
        String repeated = repeatWithStringConcat("a", 100000);
        Date end = new Date();

        long ms = end.getTime() - start.getTime();
        System.out.println(ms);
    }

    private static String repeatWithStringArray(String word, int count){
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }

    private static String repeatWithStringBuilder(String word, int count){
        StringBuilder repeatArr = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatArr.append(word);
        }
        return repeatArr.toString();
    }

    private static String repeatWithStringConcat(String word, int count){
        String repeatArr = "";
        for (int i = 0; i < count; i++) {
            repeatArr += word;
        }
        return repeatArr;
    }
}
