package bg.softuni.javaadvanced;

import java.io.*;
import java.util.Scanner;

public class A04ExtractIntegers2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        FileWriter writer = new FileWriter("C:/SoftUni/03JavaAdvanced/04StreamsFilesAndDirectories/src" +
                "/04.Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt");

        while (scanner.hasNext()){
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }
        writer.flush(); // flash from the storage / warehouse
        writer.close();
    }
}
