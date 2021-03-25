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

    @Test(expected = OperationNotSupportedException.class)
    public void testWhenNullElementsPassedToConstructor_ThenExceptionIsThrown() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testWhenValidElementsPassedToConstructor_ThenMoveReturnsCorrectBoolean() throws OperationNotSupportedException {
        assertTrue(listIterator.move()); // -> True for Element at 1 move() from 0
        assertTrue(listIterator.move()); // -> True for Element at 2 move() from 1
        assertFalse(listIterator.move());// -> False Out Of Bounds

    }

    @Test(expected = IllegalStateException.class)
    public void testWhenEmptyListIterator_ThenExceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator().print(); // empty array
    }

    @Test
    public void testWhenElementsInListIterator_ThenPrint() throws OperationNotSupportedException {
        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            assertEquals(ELEMENTS[i], listIterator.print());
        }
    }
}