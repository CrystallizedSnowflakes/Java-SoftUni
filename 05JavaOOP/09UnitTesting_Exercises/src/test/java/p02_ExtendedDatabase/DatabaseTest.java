package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    // Arrange
    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third")
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
        Person expectedPerson = new Person(4, "Forth");
        database.add(expectedPerson);
        Person[] databaseElements = database.getElements();

        assertEquals(PEOPLE.length + 1, database.getElements().length); // check length

        Person actualPerson = databaseElements[databaseElements.length - 1];

        assertEquals(expectedPerson.getId(), actualPerson.getId()); // check last by id
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername()); // check last by username
    }

    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenInvalidElementPassedToAddThenExceptionIsThrown() throws OperationNotSupportedException {
        database.add(null);
    }

    // remove
    @Test
    public void testWhenRemove_ThenLastElementIsRemoved() throws OperationNotSupportedException {
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
    public void testWhenElementsIsEmpty_ThenExceptionIsThrown() throws OperationNotSupportedException {
        // Act
        database = new Database(new Person(4, "G")); // create with one and remove twice
        database.remove();
        database.remove();
    }

    //findByUsername
    // test with null
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenUsernameNullPassedToFindByUsername_ThenExceptionIsThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    // test with empty Data
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenUsernamePassedToFindByUsernameEmptyData_ThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }

    @Test
    // test with valid username
    public void testWhenValidUsernamePassedToFindByUsername_ThenReturnPerson() throws OperationNotSupportedException {
        Person expectedPerson = PEOPLE[1];
        Person actualPerson = database.findByUsername("Second");

        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    // test on empty database
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenFindByUsernameOnEmptyArr_ThenExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove(); // to Empty Arr
        //database = new Database();
        database.findByUsername("First");
    }

    // findById

    // test with empty Data (Person == null)
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenIdPassedToFindByIdEmptyData_ThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(0);
    }

    // test with empty database (Database == null)
    @Test(expected = OperationNotSupportedException.class) // Assert
    public void testWhenFindByIdOnEmptyArr_ThenExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove(); // to Empty Arr
        //database = new Database();
        database.findById(2); // random id
    }

    // test with valid credentials
    @Test
    public void testWhenValidIdPassedThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findById(2);
        Person expectedPerson = PEOPLE[1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }
}