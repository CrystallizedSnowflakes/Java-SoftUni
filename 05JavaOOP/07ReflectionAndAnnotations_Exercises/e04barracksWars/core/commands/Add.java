package e04barracksWars.core.commands;

import e04barracksWars.interfaces.Repository;
import e04barracksWars.interfaces.Unit;
import e04barracksWars.interfaces.UnitFactory;

public class Add extends Command{

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
