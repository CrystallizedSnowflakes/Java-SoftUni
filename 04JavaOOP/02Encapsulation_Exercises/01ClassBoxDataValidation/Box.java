package e01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (!isGreaterThanZero(length)){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (!isGreaterThanZero(width)){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (!isGreaterThanZero(height)){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private boolean isGreaterThanZero(double value){
        return value > 0;
    }

    // Surface Area = 2lw + 2lh + 2wh
    public double calculateSurfaceArea(){
        return (2 * length * width) + calculateLateralSurfaceArea();
    }

    // Lateral Surface Area = 2lh + 2wh
    public double calculateLateralSurfaceArea (){
        return (2 * length * height) + (2 * width * height);
    }

    // Volume = lwh
    public double calculateVolume (){
        return length * width * height;
    }
}
