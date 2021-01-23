package bg.softuni.javaadvanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E01SumLines2 {
    public static void main(String[] args) throws IOException {
        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt");

        //read a text file
        List<String> lines = Files.readAllLines(inputPath); // readAllLines
        lines.stream()
                .map(String::toCharArray)
                .forEach(charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });

    }
}
