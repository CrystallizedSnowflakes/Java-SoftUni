package bg.softuni.javaadvanced;

import java.io.FileInputStream;
import java.io.IOException;

public class A01ReadFile {
    public static void main(String[] args) {
        // On January 1 , 1533 , Michael Angelo, -> 11101111 10111011 10111111 1001111 1101110
        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        try (FileInputStream fileInputStream = new FileInputStream(path)){
            int nextByte = fileInputStream.read();

            while (nextByte != -1){
                System.out.printf("%s ", Integer.toBinaryString(nextByte));
                nextByte = fileInputStream.read();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
