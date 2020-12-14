package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A020LambdaDemo {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("orange");
        words.add("apple");
        words.add("banana");

        
        /*Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //Integer.compare(o1, o2);
                return Integer.compare(o1.length(), o2.length());
            }
        });*/

        Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        System.out.println(String.join(" ", words));
    }
}
