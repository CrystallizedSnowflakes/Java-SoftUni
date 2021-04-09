package viceCity.models.guns;

public class Pistol extends BaseGun{
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        // Reload
        if (this.getBulletsPerBarrel() == 0 && this.getTotalBullets() > 0){
            reload();
        }
        // Fire 1 bullet per shot
        if (this.getBulletsPerBarrel() > 0) {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - 1);
        }
        return 1; //returns the number of bullets that were shot
    }

    private void reload() {
        this.setTotalBullets(this.getTotalBullets() - BULLETS_PER_BARREL);
        this.setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
