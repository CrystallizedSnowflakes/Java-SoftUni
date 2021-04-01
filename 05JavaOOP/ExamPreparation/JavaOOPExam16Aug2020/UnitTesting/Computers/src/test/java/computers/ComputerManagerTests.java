package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    // TODO: Test ComputerManager

    private ComputerManager computerManager;
    private Computer dellComputer;
    private Computer asusComputer;

    @Before
    public void setUp(){
        this.computerManager = new ComputerManager();
        dellComputer = new Computer("DELL", "A4532", 300);
        asusComputer = new Computer("ASUS", "Zen", 500);
    }

    @Test(expected = UnsupportedOperationException.class) // comes from the remove()
    public void testGetComputersWhenEmptyThrowEx(){
        this.computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullComputerThrowEx(){
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondAddThrowEx(){
        this.computerManager.addComputer(dellComputer);
        this.computerManager.addComputer(dellComputer);
    }

    @Test
    public void testAddCorrectly(){
        this.computerManager.addComputer(dellComputer);
        assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetManufacturerWithNullManufacturerThrowEx(){
        this.computerManager.getComputer(null, "test_model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetModelWithNullModelThrowEx(){
        this.computerManager.getComputer("test_manufacturer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistingComputerThrowEx(){
        this.computerManager.getComputer(dellComputer.getManufacturer(), dellComputer.getModel());
    }

    @Test
    public void testGetReturnsCorrectComputer(){
        computerManager.addComputer(dellComputer);
        computerManager.addComputer(asusComputer);
        Computer expectedComputer = this.computerManager.getComputer(dellComputer.getManufacturer(), dellComputer.getModel());
        assertNotNull(expectedComputer);
        assertEquals(dellComputer.getManufacturer(), expectedComputer.getManufacturer());
        assertEquals(dellComputer.getModel(), expectedComputer.getModel());
        assertEquals(dellComputer.getPrice(), expectedComputer.getPrice(), 0);
    }

    @Test
    public void tesGetComputersByManufacturerReturnsCorrectComputer(){
        List<Computer> expectedComputersByManufacturer = this.computerManager.getComputersByManufacturer(dellComputer.getManufacturer());
        assertNotNull(expectedComputersByManufacturer);
        assertTrue(expectedComputersByManufacturer.isEmpty());
    }

    @Test
    public void tesGetComputersByManufacturerWhenEmpty(){
        computerManager.addComputer(dellComputer);
        computerManager.addComputer(asusComputer);
        List<Computer> expectedComputersByManufacturer = this.computerManager.getComputersByManufacturer(dellComputer.getManufacturer());
        assertNotNull(expectedComputersByManufacturer);
        assertEquals(dellComputer.getManufacturer(), expectedComputersByManufacturer.get(0).getManufacturer());
    }

    @Test
    public void testRemoveComputerCorrectly(){
        computerManager.addComputer(dellComputer);
        computerManager.addComputer(asusComputer);
        Computer expectedComputer = this.computerManager.removeComputer(asusComputer.getManufacturer(), asusComputer.getModel());
        assertEquals(1, this.computerManager.getCount());
        assertEquals(asusComputer, expectedComputer);
        assertEquals(dellComputer, this.computerManager.getComputer(dellComputer.getManufacturer(), dellComputer.getModel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerThrowEx(){
        this.computerManager.removeComputer(dellComputer.getManufacturer(), dellComputer.getModel());
    }
}