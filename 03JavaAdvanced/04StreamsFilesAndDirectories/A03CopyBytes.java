package bg.softuni.javaadvanced;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class A03CopyBytes {
    public static void main(String[] args) throws IOException {
        //On January 1 , 1533 , Michael Angelo, -> 79110 749711011797114121 49 44 49535151 44 771059910497101108 6511010310110811144

        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file


        FileInputStream inputStream = new FileInputStream(path); // 2. create Stream to that file
        Scanner scanner = new Scanner(inputStream); // 3. say to the scanner to read from this entrance
        FileOutputStream outputStream = new FileOutputStream("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\" +
                "src\\04.Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");

        int nextByte = inputStream.read();

        while (nextByte != -1){
            if (nextByte == ' ' || nextByte == '\n'){
                outputStream.write(nextByte);
            } else {
                outputStream.write(String.valueOf(nextByte).getBytes());
            }
            nextByte = inputStream.read();
        }
        inputStream.close();
    }
}
