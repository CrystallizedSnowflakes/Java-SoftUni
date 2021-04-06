package e04barracksWars.core.commands;

import e04barracksWars.interfaces.Repository;
import e04barracksWars.interfaces.UnitFactory;

public class Retire extends Command{

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1]; // take second param from super(data,...) -> retire Archer
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
