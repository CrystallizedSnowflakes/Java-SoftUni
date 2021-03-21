package e04barracksWars;

import e04barracksWars.interfaces.Repository;
import e04barracksWars.interfaces.Runnable;
import e04barracksWars.interfaces.UnitFactory;
import e04barracksWars.core.Engine;
import e04barracksWars.core.factories.UnitFactoryImpl;
import e04barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
