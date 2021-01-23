package bg.softuni.javaadvanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter writer = new PrintWriter("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");

        while (scanner.hasNext()){
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        writer.flush(); // flash from the storage / warehouse
        writer.close();
    }
}
