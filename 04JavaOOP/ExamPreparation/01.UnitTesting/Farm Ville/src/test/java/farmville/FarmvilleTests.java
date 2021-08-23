package farmville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    private Farm farm;
    private Animal cow;

    @Before
    public void setUp() {
        this.farm = new Farm("Bio", 5);
        this.cow = new Animal("Cow", 3);
    }

    // getCount
    @Test
    public void testGetCountReturnsCorrectFarmAnimals(){
        this.farm.add(this.cow);
        assertEquals(1, this.farm.getCount());
    }

    //getName
    @Test
    public void testGetNameWorkProperly(){
        String farmName = this.farm.getName();
        assertEquals("Bio", farmName);
    }

    //getCapacity
    @Test
    public void testGetCapacityWorkProperly(){
        int capacity = this.farm.getCapacity();
        assertEquals(5, capacity);
    }

    //add
    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreThanCapacityShouldThrowEx(){
        this.farm = new Farm("Green", 1);
        this.farm.add(this.cow);
        Animal chicken = new Animal("Chicken", 1);
        this.farm.add(chicken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingAnimalShouldTrowEx(){
        this.farm.add(this.cow);
        this.farm.add(this.cow);
    }

    @Test
    public void testAddAnimalWorkProperly(){
        this.farm.add(this.cow);
        assertEquals(1, this.farm.getCount());
    }

    //remove
    @Test
    public void testRemoveNullAnimal(){
        this.farm.add(this.cow);
        boolean isRemoved = this.farm.remove(null);
        assertFalse("false", isRemoved);
    }

    @Test
    public void testRemoveNonExistingAnimal(){
        this.farm.add(this.cow);
        boolean isRemoved = this.farm.remove("Pepi");
        assertFalse("false", isRemoved);
    }

    @Test
    public void testRemoveExistingAnimalWorkProperly(){
        this.farm.add(cow);
        this.farm.remove("Cow");
        int count = this.farm.getCount();
        assertEquals(0, count);
    }

    //setCapacity
    @Test(expected = IllegalArgumentException.class)
    public void testSetLessThanZeroCapacityShouldThrowEx(){
        this.farm = new Farm("Ghost", -1);
    }

    @Test
    public void testSetCapacityWorkProperly(){
        assertEquals(5, this.farm.getCapacity());
    }

    //setName
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrowEx(){
        this.farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetBlankNameShouldThrowEx(){
        this.farm = new Farm("    ", 10);
    }

    @Test
    public void testSetNameWorkProperly(){
        assertEquals("Bio", this.farm.getName());
    }
}
