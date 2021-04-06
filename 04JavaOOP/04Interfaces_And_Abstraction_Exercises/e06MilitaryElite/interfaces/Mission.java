package e06MilitaryElite.interfaces;

public interface Mission {
    public void completeMission();

    public String getCodeName();

    public String getState();

    @Override
    public String toString();
}
