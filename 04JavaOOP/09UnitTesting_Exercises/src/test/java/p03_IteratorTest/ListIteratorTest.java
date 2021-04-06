package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    // Arrange
    private static final String[] ELEMENTS = new String[]{"wood", "river", "gold"};

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    // test Constructor with String element == null
    @Test(expected = OperationNotSupportedException.class)
    public void testWhenNullElementsPassedToConstructor_ThenExceptionIsThrown() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    // test move()
    @Test
    public void testWhenValidElementsPassedToConstructor_ThenMoveReturnsCorrectBoolean() throws OperationNotSupportedException {
        // "wood", "river", "gold"
        assertTrue(listIterator.move()); // -> True for Element at 1 -> "river" move() from 0
        assertTrue(listIterator.move()); // -> True for Element at 2 -> "gold"" move() from 1
        assertFalse(listIterator.move());// -> False Out Of Bounds

    }

    // test print() at empty List
    @Test(expected = IllegalStateException.class)
    public void testWhenEmptyListIterator_ThenExceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator().print(); // empty array
    }

    // test print() at List with elements
    @Test
    public void testPrintListIteratorWithElements() throws OperationNotSupportedException {
        int index = 0;
        while (listIterator.hasNext()){
            assertEquals(ELEMENTS[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }

    // test hasNext()
    @Test
    public void testWhenElementsInListIterator_ThenPrint() throws OperationNotSupportedException {
        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            assertEquals(ELEMENTS[i], listIterator.print());
        }
    }

    // test hasNext()
    @Test
    public void testHasNextReturnCorrectBoolean(){
        // "wood", "river", "gold"
        assertTrue(listIterator.hasNext()); // starts from "wood" at 0
        listIterator.move(); // -> river
        assertTrue(listIterator.hasNext());
        listIterator.move(); // -> gold
        assertFalse(listIterator.hasNext());
    }
}