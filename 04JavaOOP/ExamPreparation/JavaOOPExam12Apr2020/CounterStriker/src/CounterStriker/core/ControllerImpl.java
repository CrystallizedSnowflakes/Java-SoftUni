package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;


class The_Comparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
        if (result == 0) {
            result = Integer.compare(p2.getHealth(), p1.getHealth());
        }
        if (result == 0) {
            result = p1.getUsername().compareTo(p2.getUsername());
        }
        return result;
    }
}

public class ControllerImpl implements Controller {
    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;
    private The_Comparator comparator;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
        this.comparator = new The_Comparator();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type){
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, gun.getName());
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.findByName(gunName);
        if (gun == null){
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Player player;
        switch (type){
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, player.getUsername());
    }

    @Override
    public String startGame() {
        List<Player> alivePlayers = this.players.getModels().stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

        return this.field.start(alivePlayers);
    }

    @Override
    public String report() {
/*        return this.players.getModels().stream()
                .sorted(Comparator.comparing(f -> f.getClass().getSimpleName()))
                .sorted(Comparator.comparingInt(Player::getHealth).reversed())
                .sorted(Comparator.comparing(Player::getUsername))
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));*/

        StringBuilder sb = new StringBuilder();
        this.players.getModels().stream()
                .sorted(this.comparator)
                .forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
