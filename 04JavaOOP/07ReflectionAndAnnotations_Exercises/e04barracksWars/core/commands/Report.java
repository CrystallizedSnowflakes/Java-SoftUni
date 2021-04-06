package e04barracksWars.core.commands;

import e04barracksWars.interfaces.Repository;
import e04barracksWars.interfaces.UnitFactory;

public class Report extends Command{

    protected Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();
    }
}
