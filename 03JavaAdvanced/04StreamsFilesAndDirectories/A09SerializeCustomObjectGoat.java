package bg.softuni.javaadvanced;

import java.io.*;

public class A09SerializeCustomObjectGoat {

    private static class Goat implements Serializable{
        private String name;
        private int age;

        public Goat(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Goat goat = new Goat("Betty", 3);

        String path = "list.txt";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos); // OUTPUT file

        outputStream.writeObject(goat); // write
        outputStream.close(); // close

        // DESERIALIZATION
        // read ArrayList from the same file
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.txt"));

        Object object = inputStream.readObject(); // check if it is an object
        if (object instanceof Goat) {
            Goat restoreGoat = (Goat) object;

            System.out.println(restoreGoat.age);
            System.out.println(restoreGoat.name);
        }
    }
}
