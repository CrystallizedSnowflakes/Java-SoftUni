package bg.softuni.basics;

import java.util.Scanner;

public class E01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String anisBook = scanner.nextLine();
        String book = scanner.nextLine();

        boolean isFound = false;
        int countOfCheckedBooks = 0;
        while(!book.equals("No More Books")){
            if (book.equals(anisBook)){
                isFound = true;
                break;
            }
            countOfCheckedBooks++;
            book = scanner.nextLine();
        }
        if (isFound){
            System.out.printf("You checked %d books and found it.", countOfCheckedBooks);
        }else{
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", countOfCheckedBooks);
        }
    }
}
