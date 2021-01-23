package bg.softuni.javaadvanced;

import java.io.File;

public class A07ListFiles {
    public static void main(String[] args) {
        //FOLDER
        String fileName = "C:/SoftUni/03JavaAdvanced/04StreamsFilesAndDirectories/" +
                "src/04.Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);
        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
