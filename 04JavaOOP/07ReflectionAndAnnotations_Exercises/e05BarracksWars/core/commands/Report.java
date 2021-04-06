package e05BarracksWars.core.commands;

import e05BarracksWars.interfaces.Inject;
import e05BarracksWars.interfaces.Repository;

public class Report extends Command{

    @Inject
    private Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
