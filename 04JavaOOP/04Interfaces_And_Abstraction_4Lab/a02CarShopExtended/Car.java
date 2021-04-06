package a02CarShopExtended;

public interface Car {
    Integer TIRES = 4; // = public static final

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
