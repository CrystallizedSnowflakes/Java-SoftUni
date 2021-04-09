package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        // Reload
        if (this.getBulletsPerBarrel() == 0 && this.getTotalBullets() > 0){
            reload();
        }
        // Fire 5 bullets per shot
        if (this.getBulletsPerBarrel() > 0) {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - 5);
        }
        return 5; //returns the number of bullets that were shot
    }

    private void reload() {
        this.setTotalBullets(this.getTotalBullets() - BULLETS_PER_BARREL);
        this.setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
