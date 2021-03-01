package a04Holiday;

public enum DiscountType {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double percentage;

    private DiscountType(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
