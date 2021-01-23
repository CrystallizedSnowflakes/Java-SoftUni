package bg.softuni.javaadvanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E02SumBytes {
    public static void main(String[] args) throws IOException {
        // the sum of the ASCII symbols of all characters inside of the file.
        //On January 1 , 1533 ,             |
        //Michael Angelo,                   |
        //then fifty-seven years old,       |
        //writes                            |-> 12488
        //from Florence to                  |
        //Tommaso de' Cavalieri,            |
        //a youth of noble Roman family,    |

        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt");

        long sum = 0;
        byte[] values = Files.readAllBytes(inputPath); // readAllBytes
        for (byte value : values) {
            if (value == 10 || value == 13){
                continue;
            }
            sum += value;
        }

        System.out.println(sum);
    }
}
