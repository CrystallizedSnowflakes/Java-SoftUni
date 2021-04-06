package e06MilitaryElite.enums;

public enum Corp {

    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String corpType;

    Corp(String corpType) {
        this.corpType = corpType;
    }

    public String getCorpType() {
        return corpType;
    }

    public static boolean isValidCorps(String corps) {
        return corps.equals(AIRFORCES.getCorpType()) || corps.equals(MARINES.getCorpType());
    }

    @Override
    public String toString () {
        return this.getCorpType();
    }
}
