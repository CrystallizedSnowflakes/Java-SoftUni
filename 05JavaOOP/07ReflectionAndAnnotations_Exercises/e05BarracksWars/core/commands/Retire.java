package e05BarracksWars.core.commands;

import e05BarracksWars.interfaces.Inject;
import e05BarracksWars.interfaces.Repository;

public class Retire extends Command{

    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1]; // take second param from super(data,...) -> retire Archer
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
