package a01CarShop;

public interface Car {
    Integer TIRES = 4; // = public static final

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
