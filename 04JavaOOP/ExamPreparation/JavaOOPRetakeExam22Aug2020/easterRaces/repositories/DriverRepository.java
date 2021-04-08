package easterRaces.repositories;

import easterRaces.entities.drivers.Driver;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        Driver driver = this.models.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
        return driver;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Driver model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.models.remove(model);
    }
}
