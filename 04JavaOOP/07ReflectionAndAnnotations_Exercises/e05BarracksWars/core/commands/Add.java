package e05BarracksWars.core.commands;

import e05BarracksWars.interfaces.Inject;
import e05BarracksWars.interfaces.Repository;
import e05BarracksWars.interfaces.Unit;
import e05BarracksWars.interfaces.UnitFactory;

public class Add extends Command{
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
