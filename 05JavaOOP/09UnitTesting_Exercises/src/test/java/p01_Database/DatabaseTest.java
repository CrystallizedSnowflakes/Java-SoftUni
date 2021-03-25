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

    @Test
    public void testWhenCorrectElementsArePassedThenCreateDatabaseInstance() {
        // Assert - expected - actual
        assertEquals(ELEMENTS.length, database.getElements().length);
        assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenMoreThanSixteenElementsArePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        // Arrange
        // Integer[] elements = new Integer[17];
        // Act
        // Database database = new Database(elements);
        database = new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenElementsLessThanOnePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database();
    }

    // add
    @Test
    public void testWhenValidElementPassedToAddThenElementIsAddedAtLastPosition() throws OperationNotSupportedException{
        int expectedElement = 15;
        database.add(15);
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length + 1, database.getElements().length);
        assertEquals(Integer.valueOf(expectedElement), databaseElements[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenInvalidElementPassedToAddThenExceptionIsThrown() throws OperationNotSupportedException {
        database.add(null);
    }

    // remove
    @Test
    public void testWhenRemoveThenLastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();

        // Assert
        assertEquals(ELEMENTS.length - 1, database.getElements().length);
        assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenElementsIsEmptyThenExceptionIsThrown() throws OperationNotSupportedException {
        // Act
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }
}