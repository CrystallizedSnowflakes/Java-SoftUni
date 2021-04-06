package CounterStriker.models.guns;

public class Rifle extends GunImpl{

    private static final int BULLETS_PER_SHOOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_PER_SHOOT){
            return 0;
        }
        super.decreaseBullets(BULLETS_PER_SHOOT);
        return BULLETS_PER_SHOOT;
    }
}
