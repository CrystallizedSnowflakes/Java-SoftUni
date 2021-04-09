package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        Deque<Player> civilians = new ArrayDeque<>(civilPlayers); //FIFO queue
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels()); //FIFO queue

        // mainPlayer attack first
        Player civilian = civilians.poll(); // returns null if the queue is empty
        Gun enemyGun = guns.poll();
        // shooting
        /** The main player stops shooting only if he runs out of guns or until all the civil players are dead*/
        while ( civilian != null && enemyGun != null ){

            while (enemyGun.canFire() && civilian.isAlive()) {
                int bulletsPerShot = enemyGun.fire();
                civilian.takeLifePoints(bulletsPerShot);
            }

            // after the shooting
            if (enemyGun.canFire()){
                civilian = civilians.poll(); // take next civilian and continue shooting
            } else if (civilian.isAlive()){
                enemyGun = guns.poll(); // take next gun and continue shooting
            }
        }

        // civilians attack second
        for (Player civilPlayer : civilPlayers) { //Collection

            if (civilPlayer.isAlive()){
                Deque<Gun> civiliansGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun civilianGun = civiliansGuns.poll();
                while (civilianGun != null){

                    // If the main player dies, the whole action ends
                    while (civilianGun.canFire() && mainPlayer.isAlive()){
                        int bulletsPerShot = civilianGun.fire();
                        mainPlayer.takeLifePoints(bulletsPerShot);
                    }
                    if (!mainPlayer.isAlive()){ // mainPlayer is dead
                        return;
                    }
                    civilianGun = civiliansGuns.poll(); // take next gun and continue shooting
                }
            }
        }
    }
}
