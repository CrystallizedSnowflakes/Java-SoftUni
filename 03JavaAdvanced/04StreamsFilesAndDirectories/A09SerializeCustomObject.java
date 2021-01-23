package bg.softuni.javaadvanced;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class A09SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // SERIALIZATION

        List<String> names = new ArrayList<>();
        names.add("Martin");
        names.add("Pesho");
        names.add("Gosho");
        names.add("Optimus Prime");

        String path = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                        "\\04.Files-and-Streams-Lab-Resources\\list.txt";

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos); // OUTPUT file

        outputStream.writeObject(names); // write
        outputStream.close(); // close

        // DESERIALIZATION
        // read ArrayList from the same file
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path)); // INPUT to the same file

        List<String> readNames = (List<String>) inputStream.readObject();

        for (String name : readNames) {
            System.out.println(name);
        }
    }
}
