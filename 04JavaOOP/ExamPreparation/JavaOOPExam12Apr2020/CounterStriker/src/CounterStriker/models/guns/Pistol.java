package CounterStriker.models.guns;

public class Pistol extends GunImpl{

    private static final int BULLET_PER_SHOOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLET_PER_SHOOT){
            return 0;
        }
        super.decreaseBullets(BULLET_PER_SHOOT);
        return BULLET_PER_SHOOT;
    }
}
