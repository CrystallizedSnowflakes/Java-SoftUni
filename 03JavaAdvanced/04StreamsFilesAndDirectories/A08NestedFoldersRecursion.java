package bg.softuni.javaadvanced;

import java.io.File;

public class A08NestedFoldersRecursion {
    public static int foldersCount = 0;

    public static void main(String[] args) {
        //FOLDER
        String fileName = "C:/SoftUni/03JavaAdvanced/04StreamsFilesAndDirectories/" +
                "src/04.Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);
        dfs(file); // DFS Depth First Search - обхождане в дълбочина

        System.out.println(foldersCount + " folders");
    }

    private static void dfs(File file) {
        //Bottom-case
        //Step
        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()){
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
