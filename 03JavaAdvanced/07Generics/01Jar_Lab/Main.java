package Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<Integer>();
        jar.add(13);

        Jar<String> jarStr = new Jar<String>();
        jarStr.add("13");

        System.out.println(jar.remove());
        System.out.println(jarStr.remove());

    }
}
