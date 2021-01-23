package bg.softuni.javaadvanced;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class A05WriteEveryThirdLine2 {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        List<String> strings = Files.readAllLines(Path.of(fileName));
        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i += 3) {
            lines.add(strings.get(i));
        }
        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        Files.write(Path.of(path), lines, StandardCharsets.UTF_8);
    }
}
