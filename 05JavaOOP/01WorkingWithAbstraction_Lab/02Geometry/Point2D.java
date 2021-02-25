package a02Geometry;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isGreaterOrEqualByX(Point2D otherPoint) {
        return this.x >= otherPoint.x;
    }

    public boolean isWithEqualX(Point2D otherPoint){
        return this.x == otherPoint.x;
    }

    public boolean isLessOrEqualByX(Point2D otherPoint) {
        return this.x <= otherPoint.x;
    }

    public boolean isGreaterOrEqualByY(Point2D otherPoint) {
        return this.y >= otherPoint.y;
    }

    public boolean isWithEqualY(Point2D otherPoint){
        return this.y == otherPoint.y;
    }

    public boolean isLessOrEqualByY(Point2D otherPoint) {
        return this.y <= otherPoint.y;
    }
}
