package bankSafe;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {
    //TODO: Write your tests here

    //Arrange - Preconditions
    private Item item;
    private BankVault bankVault;
       

    // test constructor
    // Act - Test single Behavior
    @Before
    public void setUp(){
        this.item = new Item("Pesho", "1");
        this.bankVault = new BankVault();
    }

    // Assert - Postconditions
    // getVaultCells
    @Test(expected = UnsupportedOperationException.class) // unmodifiableMap
    public void testGetVaultCellsByModifyingTheMapShouldThrowEx() {
        Map<String, Item> vaultCells = this.bankVault.getVaultCells();
        vaultCells.put("D3", item); // there is no C4 cell existing
    }

    // addItem
    @Test(expected = IllegalArgumentException.class)
    public void testAddToNonExistingCellShouldThrowEx() throws OperationNotSupportedException {
        String expected = "Cell doesn't exist!";
        String actual = this.bankVault.addItem("C24", this.item);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToTakenCellShouldThrowEx() throws OperationNotSupportedException {
        this.bankVault.addItem("C2", this.item);
        String expected = "Cell is already taken!";
        Item item2 = new Item("Gosho", "1");
        String actual = this.bankVault.addItem("C2", item2);
        assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToCellNullItemShouldThrowEx() throws OperationNotSupportedException {
        boolean itemExist = this.bankVault.getVaultCells().containsValue(null); //true
        String expected = "Item is already in cell";
        if (itemExist) {
            String actual = this.bankVault.addItem("A1", null);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testAddToCellShouldWorkProperly() throws OperationNotSupportedException {
        String expected = "Item:1 saved successfully!";
        String actual = this.bankVault.addItem("C2", item);
        assertEquals(expected, actual);
        assertEquals(this.bankVault.getVaultCells().get("C2"), item);
    }

    //remove
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromNonExistingCellThrowEx() {
        String expected = "Cell doesn't exists!";
        String actual = this.bankVault.removeItem("D8", null);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromCellNonExistingItemThrowEx(){
        String expected = "Item in that cell doesn't exists!";
        String actual = this.bankVault.removeItem("C2", item);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveFromExistingCellNullItemThrowEx(){
        String expected = "Item in that cell doesn't exists!";
        String actual = this.bankVault.removeItem("C2", null);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveFromCellShouldTWorkProperly() throws OperationNotSupportedException{
        String expected = String.format("Remove item:%s successfully!", item.getItemId());
        this.bankVault.addItem("C2", item);
        String actual = this.bankVault.removeItem("C2", item);
        assertEquals(expected, actual);
        assertNull(this.bankVault.getVaultCells().get("C2"));
    }
}