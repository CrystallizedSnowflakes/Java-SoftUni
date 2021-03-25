package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    // Arrange
    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C")
    };

    private Database database;

    // Act
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testWhenCorrectElementsArePassedThenCreateDatabaseInstance() {
        // Assert - expected - actual
        assertEquals(PEOPLE.length, database.getElements().length);
        assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenMoreThanSixteenElementsArePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        // Arrange
        // Integer[] elements = new Integer[17];
        // Act
        // Database database = new Database(elements);
        database = new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenElementsLessThanOnePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database();
    }

    // add
    @Test
    public void testWhenValidElementPassedToAddThenElementIsAddedAtLastPosition() throws OperationNotSupportedException{
        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        Person[] databaseElements = database.getElements();
        assertEquals(PEOPLE.length + 1, database.getElements().length);
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenInvalidElementPassedToAddThenExceptionIsThrown() throws OperationNotSupportedException {
        database.add(null);
    }

    // remove
    @Test
    public void testWhenRemoveThenLastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Person[] databaseElements = database.getElements();

        // Assert
        assertEquals(PEOPLE.length - 1, database.getElements().length);
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenElementsIsEmptyThenExceptionIsThrown() throws OperationNotSupportedException {
        // Act
        database = new Database(new Person(4, "G"));
        database.remove();
        database.remove();
    }

    //findByUsername
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenUsernameNullPassedToFindByUsernameThenExceptionIsThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testWhenValidUsernamePassedToFindByUsernameThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("B");
        Person expectedPerson = PEOPLE[1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenFindByUsernameOnEmptyArrThenExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername("A");
    }

    // findById
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenFindByIdOnEmptyArrThenExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove(); // to Empty Arr
        database.findById(2); // random id
    }

    @Test
    public void testWhenValidIdPassedThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findById(2);
        Person expectedPerson = PEOPLE[1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }
}