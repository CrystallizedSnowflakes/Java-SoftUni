package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    // Arrange
    private static final Integer[] ELEMENTS = new Integer[]{4,6,19,32,5};

    private Database database;

    // Act
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    // test constructor
    @Test
    public void testConstructorHasCreatedAValidObject() {
        // Assert - expected - actual
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length, databaseElements.length);
        assertArrayEquals(ELEMENTS, databaseElements);
/*        for (int i = 0; i < databaseElements.length; i++) {
            assertEquals(ELEMENTS[i], databaseElements[i]);
        }*/
    }

    // test constructor with 17 elements => should trow ex and we will catch it
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testConstructor_WhenMoreThanSixteenElementsArePassed_ThenAnExceptionShouldBeThrown() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        database = new Database(numbers);
    }

    // test constructor with 0 elements
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testConstructor_WhenElementsLessThanOneIsPassed_ThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        //database = new Database();
        Integer[] emptyArr = new Integer[0];
        database = new Database(emptyArr);
    }

    // add 15 at last position
    @Test
    public void testAdd_WhenValidElementIsPassed_ThenElementShouldBeAddedAtLastPosition() throws OperationNotSupportedException{
        int expectedElement = 15;
        database.add(15);
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length + 1, databaseElements.length);

        int lastIndex = databaseElements.length - 1;
        Integer actualElement = databaseElements[lastIndex];
        assertEquals(Integer.valueOf(expectedElement), actualElement);
    }

    // add(null) => should trow ex and we will catch it
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testAdd_WhenInvalidElementIsPassed_ThenExceptionIsThrown() throws OperationNotSupportedException {
        Integer number = null;
        database.add(number);
        //database.add(null);
    }

    // remove
    @Test
    public void testWhenRemove_ThenLastElementIsRemoved() throws OperationNotSupportedException {
        //new Integer[]{4,6,19,32,5};
        database.remove();
        Integer[] databaseElements = database.getElements(); //4,6,19,32

        // Assert
        // check length 4 == 4
        assertEquals(ELEMENTS.length - 1, databaseElements.length);
        // check previous element 32 == 32
        assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testRemoveWhenIsEmpty_ThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        // Act
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }
}