package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlanetRepository implements Repository<Planet> {
    private Collection<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets);
    }

    @Override
    public void add(Planet planet) {
        if (this.planets.stream().noneMatch(a -> a.getName().equals(planet.getName()))) {
            this.planets.add(planet);
        }
    }

    @Override
    public boolean remove(Planet planet) {
        return this.planets.remove(planet);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
