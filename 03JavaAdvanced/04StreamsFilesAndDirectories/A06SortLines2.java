package bg.softuni.javaadvanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class A06SortLines2 {
    public static void main(String[] args) {
        //FILE

        String inputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        String outputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path path = Paths.get(inputPath);

        try {
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream()
                    .filter(l -> !l.isBlank())
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());

            Files.write(Paths.get(outputPath), lines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
