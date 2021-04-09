package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;

    @Before
    public void setUp(){
        this.spaceship = new Spaceship("tast_name", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull(){
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty(){
        new Spaceship("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailBelowZero(){
        new Spaceship("SpaceShip", -1);
    }

    @Test
    public void testGetAstronautsCountShouldReturnTrueWhenAdded(){
    spaceship.add(new Astronaut("test_1", 100));
    spaceship.add(new Astronaut("test_2", 100));
    assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetAstronautsCountShouldReturnZeroWhenEmpty(){
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAstronautShouldFail(){
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_1", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail(){
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_2", 100));
    }

    @Test
    public void testRemoveAstronautShouldReturnFalseWhenNoSuchAdded(){
        this.spaceship.add(new Astronaut("test_1", 100));
        assertFalse(this.spaceship.remove("other"));
    }

    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded(){
        this.spaceship.add(new Astronaut("test_1", 100));
        assertTrue(this.spaceship.remove("test_1"));
    }
}
