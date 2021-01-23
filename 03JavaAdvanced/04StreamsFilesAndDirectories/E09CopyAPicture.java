package bg.softuni.javaadvanced;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E09CopyAPicture {
    public static void main(String[] args) throws IOException {
        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\waterlilly.jpg";

        byte[] buffer = Files.readAllBytes(Path.of(path));

        new FileOutputStream("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
        "04.Files-and-Streams-Exercises-Resources\\copy-waterlilly.jpg").write(buffer);

/*        String encoded = Base64.getEncoder().encodeToString(buffer);
        new PrintWriter("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\copy-waterlilly.txt").write(encoded); // /9j/ -> ==*/
    }
}
