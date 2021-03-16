package solidLab.p05_DependencyInversion.p03_Database;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Courses courses = new Courses(new Data());
        Courses coursesTwo = new Courses(new FasterData());
    }
}
