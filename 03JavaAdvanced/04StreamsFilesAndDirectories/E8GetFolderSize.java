package bg.softuni.javaadvanced;

import java.io.File;

public class E8GetFolderSize {
    public static void main(String[] args) {
        String folderPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(folderPath); //dir

        long folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
