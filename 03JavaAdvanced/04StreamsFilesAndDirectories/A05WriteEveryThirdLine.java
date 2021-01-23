package bg.softuni.javaadvanced;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        /*BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();*/

        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories" +
                "\\src\\04.Files-and-Streams-Lab-Resources\\input.txt";  // 1. point the file

        BufferedReader reader = new BufferedReader(new FileReader(path));

        Stream<String> lines = reader.lines();
        List<String> stringLines = lines.collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\SoftUni\\03JavaAdvanced\\" +
                "04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));

        for (int i = 0; i < stringLines.size(); i++) {
            if ((i + 1) % 3 == 0){
                writer.write(stringLines.get(i));
                writer.newLine();
            }
        }
        writer.close();
    }
}
