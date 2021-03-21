package e05BarracksWars;

import e05BarracksWars.core.CommandInterpreterImpl;
import e05BarracksWars.interfaces.Repository;
import e05BarracksWars.interfaces.Runnable;
import e05BarracksWars.interfaces.UnitFactory;
import e05BarracksWars.core.Engine;
import e05BarracksWars.core.factories.UnitFactoryImpl;
import e05BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
        engine.run();
    }
}
