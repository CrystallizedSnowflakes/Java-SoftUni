package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {
    // Arrange - Preconditions
    private static final int ATTACK = 10;
    private static final int DURABILITY = 13;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){
        // Act - Test single Behavior
        this.axe = createAxe(ATTACK, DURABILITY);
        this.dummy = createDummy();
    }

    // Test constructor
    @Test
    public void testAxeConstructorShouldSetCorrectAttackAndDurability(){
        // Assert - Postconditions
        assertEquals(ATTACK, this.axe.getAttackPoints()); // expected, actual
        assertEquals("Expected and actual durability are not matching", DURABILITY, this.axe.getDurabilityPoints());
    }

    //•	Test attacking with a broken weapon
    @Test(expected = IllegalStateException.class) // Assert to catch Exception
    public void testAxeAttackShouldFailIfAxeHasZeroDurability(){ // Broken Axe
        Axe axe = createAxe(ATTACK, 0); // edge case
        axe.attack(this.dummy);
    }

    //•	Test if weapon loses durability after each attack
    @Test
    public void testAxeLoosesSingleDurabilityPointWhenAttackingADummy(){
        // Act - Test single Behavior
        this.axe.attack(this.dummy);
        int expectedDurabilityToBeDecreasedByOnePoint = DURABILITY - 1;
        assertEquals(expectedDurabilityToBeDecreasedByOnePoint, axe.getDurabilityPoints());
    }

    private Dummy createDummy(){
        return new Dummy(100, 100);
    }

    private Axe createAxe(int attack, int durability){
        return new Axe(attack, durability);
    }
}
