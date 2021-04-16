package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp(){
        this.aquarium = new Aquarium("Blue", 5);
        this.fish = new Fish("Toni");
    }

    //getName
    @Test
    public void testGetNameWorkProperly(){
        String aquariumName = this.aquarium.getName();
        assertEquals("Blue", aquariumName);
    }

    //setName
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrowEx(){
        this.aquarium = new Aquarium(null, 10);
    }

    //getCapacity
    @Test
    public void testGetCapacityWorkProperly(){
        int capacity = this.aquarium.getCapacity();
        assertEquals(5, capacity);
    }

    //setCapacity
    @Test(expected = IllegalArgumentException.class)
    public void testSetLessThanZeroCapacityShouldThrowEx(){
        this.aquarium = new Aquarium("Red", -1);
    }

    //getCount
    @Test
    public void testGetCountWorkProperly(){
        this.aquarium.add(fish);
        int count = this.aquarium.getCount();
        assertEquals(1, count);
    }

    //add
    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreThanCapacityShouldThrowEx(){
        this.aquarium = new Aquarium("Yellow", 1);
        this.aquarium.add(fish);
        Fish fish2 = new Fish("Koko");
        this.aquarium.add(fish2);
    }

    //remove
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullFishShouldThrowEx(){
        this.aquarium.add(fish);
        this.aquarium.remove("Pepi");
    }

    @Test
    public void testRemoveExistingFishWorkProperly(){
        this.aquarium.add(fish);
        this.aquarium.remove("Toni");
        int count = this.aquarium.getCount();
        assertEquals(0, count);
    }

    //sellFish
    @Test(expected = IllegalArgumentException.class)
    public void testSellNonExistingFishShouldThrowEx(){
        this.aquarium.add(fish);
        this.aquarium.sellFish("Dido");
    }

    @Test
    public void testSellExistingFishWorkProperly(){
        this.aquarium.add(fish);
        Fish toni = this.aquarium.sellFish("Toni");
        assertEquals("Toni", toni.getName());
        boolean isAvailable = toni.isAvailable();
        assertFalse(isAvailable);
    }

    //report
    @Test
    public void testReportWorkProperly(){
        this.aquarium.add(fish);
        String report = this.aquarium.report();
        String expected = String.format("Fish available at %s: %s", this.aquarium.getName(), fish.getName());
        assertEquals(expected, report);
    }
}

