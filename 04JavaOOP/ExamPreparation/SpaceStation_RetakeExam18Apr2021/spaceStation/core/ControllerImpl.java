package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.bags.Bag;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronauts;
    private Repository<Planet> planets;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
        this.exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        this.astronauts.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        this.planets.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautByName = this.astronauts.findByName(astronautName);
        if (astronautByName == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronauts.remove(astronautByName);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronautsAboveSixtyOxygen = this.astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());
        int initialSize = astronautsAboveSixtyOxygen.size();

        if (astronautsAboveSixtyOxygen.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planetByName = this.planets.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planetByName, astronautsAboveSixtyOxygen);

        List<Astronaut> aliveAstronauts = astronautsAboveSixtyOxygen.stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        int deadAstronauts = initialSize - aliveAstronauts.size();
        exploredPlanetsCount++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanetsCount));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());
        for (Astronaut astronaut : this.astronauts.getModels()) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()));
            sb.append(System.lineSeparator());

            Bag bag = astronaut.getBag();
            if (bag.getItems().isEmpty()){
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            } else {
                String collectedItems = String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, bag.getItems());
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, collectedItems));
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
