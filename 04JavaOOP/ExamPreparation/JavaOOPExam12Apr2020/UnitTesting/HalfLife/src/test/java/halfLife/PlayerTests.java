package halfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    private static final int DAMAGE = 100;

    private Player player;
    private Gun gun;

    @Before
    public void setUp(){
        player = new Player("Ivan", 50);
        gun = new Gun("Pistol", 10);
    }

    //getUsername
    @Test
    public void testGetUsernameWorkProperly(){
        assertEquals("Ivan", this.player.getUsername());
    }

    //setUsername
    @Test(expected = NullPointerException.class)
    public void testSetNullUsernameShouldThrowEx(){
        this.player = new Player(null, 50);
        String actual = this.player.getUsername();
        assertEquals("Cannot be null!", actual);
        assertNull(this.player.getUsername());
    }

    @Test
    public void testSetUsernameWorkProperly(){
        String actual = this.player.getUsername();
        assertEquals("Ivan", actual);
    }

    //getHealth
    @Test
    public void testGetHealthWorkProperly(){
        assertEquals(50, this.player.getHealth());
    }

    //setHealth
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthBelowZeroShouldThrowEx(){
        player = new Player("Gogo", -10);
    }

    @Test
    public void testSetHealthWorkProperly(){
        assertEquals(50, this.player.getHealth());
    }

    //getGuns
    @Test(expected = UnsupportedOperationException.class)
    public void testGetGunsWhenModifyShouldThrowEx(){
        this.player.getGuns().add(gun);
    }

    //takeDamage
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageOnZeroHealthShouldThrowEx(){
        this.player = new Player("Niki", 0);
        this.player.takeDamage(DAMAGE);
    }

    @Test
    public void testTakeDamageWhenDamageIsMoreThanTheHealthReturnsZeroHealth(){
        this.player.takeDamage(DAMAGE);
        int actualHealth = this.player.getHealth();
        assertEquals(0, actualHealth);
    }

    @Test
    public void testTakeDamageWorkProperly(){
        this.player = new Player("Iva", 200);
        this.player.takeDamage(DAMAGE);
        int actual = this.player.getHealth();
        assertEquals(100, actual);
    }

    //addGun
    @Test(expected = NullPointerException.class)
    public void testAddNullGunShouldThrowEx(){
        this.player.addGun(null);
    }

    @Test
    public void testAddGunWorkProperly(){
        this.player.addGun(gun);
        String actualName = this.player.getGun("Pistol").getName();
        int actualBullets = this.player.getGun("Pistol").getBullets();
        assertEquals("Pistol", actualName);
        assertEquals(10, actualBullets);
    }

    //removeGun
    @Test
    public void testRemoveGunWorkProperly(){
        this.player.addGun(gun);
        Gun pistol = this.player.getGun("Pistol");
        assertEquals(this.gun, pistol);
        this.player.removeGun(pistol);
        assertNull(this.player.getGun("Pistol"));
    }
}
