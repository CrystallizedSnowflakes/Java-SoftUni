package bg.softuni.javaadvanced;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class A08NestedFolders {
    public static void main(String[] args) {
        // FOLDER
        // BFS Breadth First Search - обхождане в дълбочина
        String path = "C:/SoftUni/03JavaAdvanced/04StreamsFilesAndDirectories/" +
                "src/04.Files-and-Streams-Lab-Resources/Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>(); // Queue
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll()
                    ;
            System.out.println(current.getName());

            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
