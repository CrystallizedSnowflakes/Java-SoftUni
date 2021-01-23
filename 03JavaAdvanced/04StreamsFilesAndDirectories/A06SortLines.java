package bg.softuni.javaadvanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class A06SortLines {
    public static void main(String[] args) throws IOException {
        //FILE

        String pathOf = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        Path path = Paths.get(pathOf);

        //BufferedReader reader = Files.newBufferedReader(path);

        List<String> strings = Files.readAllLines(path);
        Collections.sort(strings);

        Files.write(Paths.get("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt"), strings);
    }
}
