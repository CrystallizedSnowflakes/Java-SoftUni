package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player{

    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
        if (gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        int healthDamage = points > this.armor ? points - this.armor : 0;
        this.setArmor(Math.max(this.armor - points, 0));
        this.setHealth(Math.max(this.health - healthDamage, 0));

/*        if (points > this.getArmor()) {
            points -= this.getArmor();
            this.setArmor(0);
            this.setHealth(Math.max(this.health - points, 0));
        } else {
            this.setArmor(this.armor - points);
        }*/
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        /** "{player type}: {player username} */
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), this.username)).append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.health)).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.armor)).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.gun.getName()));

        return sb.toString().trim();
    }
}
