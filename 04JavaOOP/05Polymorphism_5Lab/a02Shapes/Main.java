package a02Shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3.0, 4.0);
        Circle circle = new Circle(4.0);

        System.out.println(rect.getArea());
        System.out.println(rect.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
    }
}
