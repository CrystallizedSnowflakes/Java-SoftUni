package bg.softuni.javaadvanced;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E05LineNumbersLambda {
    public static int row = 1;
    public static void main(String[] args) throws IOException {


        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");

        String outputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\05LineNumbersOutput.txt";
        File outputFile = new File(outputPath);

        List<String> lines = Files.readAllLines(inputPath); // read

        PrintWriter outputWriter = new PrintWriter(outputFile);

        lines.forEach(line -> outputWriter.println(row++ + ". " + line));

        outputWriter.flush();
        outputWriter.close();
    }
}
