package workshop;

import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();
        SmartStack stack = new SmartStack();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }

        stack.forEach(System.out::println);

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        LinkedList linkedList = new LinkedList();

        int[] firstArr = linkedList.toArray();

        for (int i = 0; i < 4; i++) {
            linkedList.addLast(i + 1);
        }


        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());

        linkedList.forEach(System.out::println);
    }
}
