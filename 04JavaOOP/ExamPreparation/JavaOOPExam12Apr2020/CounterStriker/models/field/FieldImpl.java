package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field{

    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = players.stream()
                .filter(p -> p instanceof Terrorist)
                .collect(Collectors.toList());

        List<Player> contraTerrorists = players.stream()
                .filter(p -> p instanceof CounterTerrorist)
                .collect(Collectors.toList());

        while (terrorists.stream().anyMatch(Player::isAlive) && contraTerrorists.stream().anyMatch(Player::isAlive)){
            /** The terrorists attack first and after that the counter terrorists.  */
            for (Player terrorist : terrorists) {
                for (Player contraTerrorist : contraTerrorists) {
                    int points = terrorist.getGun().fire();
                    contraTerrorist.takeDamage(points);
                }
            }

            contraTerrorists = contraTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            for (Player contraTerrorist : contraTerrorists) {
                for (Player terrorist : terrorists) {
                    int points = contraTerrorist.getGun().fire();
                    terrorist.takeDamage(points);
                }
            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }

        boolean areTerroristsWinners = terrorists.stream().anyMatch(Player::isAlive);
        return areTerroristsWinners ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
