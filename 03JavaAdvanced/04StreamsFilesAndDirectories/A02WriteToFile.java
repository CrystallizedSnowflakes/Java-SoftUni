package bg.softuni.javaadvanced;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class A02WriteToFile {
    public static void main(String[] args) throws IOException {
        //On January 1 , 1533 , Michael Angelo,  -> On January 1 , 1533 , Michael Angelo,

        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                        "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        FileInputStream inputStream = new FileInputStream(path); // 2. create Stream to that file
        Scanner scanner = new Scanner(inputStream); // 3. say to the scanner to read from this entrance

        String lookUpTable = ",.!?";

        FileOutputStream outputStream = new FileOutputStream("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");

        while (scanner.hasNext()){
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!lookUpTable.contains(String.valueOf(symbol))){
                    outputStream.write(symbol);
                }
            }
            outputStream.write('\n');
        }
        inputStream.close();
        outputStream.flush(); // if there is data rest
        outputStream.close();
    }
}
