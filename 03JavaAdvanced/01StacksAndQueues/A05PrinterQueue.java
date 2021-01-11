package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String task = scanner.nextLine();

        while (!task.equals("print")){

            if (task.equals("cancel")){
                if (printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                printerQueue.offer(task);
            }
            task = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.pollFirst());
            //System.out.println(printerQueue.poll());
        }
    }
}
