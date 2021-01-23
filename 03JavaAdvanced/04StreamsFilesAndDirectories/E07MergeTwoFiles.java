package bg.softuni.javaadvanced;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path inputOne = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\inputOne.txt");

        Path inputTwo = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        // read from first file
        List<String> linesFirst = Files.readAllLines(inputOne);
        // read from second file
        List<String> linesSecond = Files.readAllLines(inputTwo);

        // create third file to print there the result
        File outputFile =  new File("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\07merge.txt");
        PrintWriter outputWriter = new PrintWriter(outputFile);

        linesFirst.forEach(line -> outputWriter.println(line));
        linesSecond.forEach(outputWriter::println);

        outputWriter.close();
    }
}
