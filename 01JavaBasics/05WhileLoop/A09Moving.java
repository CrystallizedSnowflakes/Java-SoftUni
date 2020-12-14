package bg.softuni.basics;

import java.util.Scanner;

public class A09Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int space = width * length * height;
        int currentSpace = 0;
        boolean hasSpace = true;

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            int boxes = Integer.parseInt(input);
            currentSpace += boxes;
            if (currentSpace > space){
                int neededSpace = currentSpace - space;
                System.out.printf("No more free space! You need %d Cubic meters more.", neededSpace);
                hasSpace = false;
                break;
            }
            input = scanner.nextLine();
        }
        if (hasSpace){
            System.out.printf("%d Cubic meters left.", space - currentSpace);
        }
    }
}
