package e03barracksWars;

import e03barracksWars.interfaces.Repository;
import e03barracksWars.interfaces.Runnable;
import e03barracksWars.interfaces.UnitFactory;
import e03barracksWars.core.Engine;
import e03barracksWars.core.factories.UnitFactoryImpl;
import e03barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
