package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> list;

    @Before
    public void setUp(){
        this.list = new CustomLinkedList<>();
    }

    // test constructor with Reflection
    @Test
    public void testConstructorCreatingLinkedListShouldHaveZeroCount() throws IllegalAccessException {
        Field field = Arrays.stream(CustomLinkedList.class.getDeclaredFields())
                .filter(f -> f.getName().equals("count"))
                .findFirst()
                .orElse(null);

        assertNotNull("Field count was null! Invalid object state", field);
        field.setAccessible(true);
        int count = (int) field.get(this.list);
        assertEquals("Created empty LinkedList did not have zero count", 0, count);
    }

    // get
    @Test(expected = IllegalArgumentException.class)
    public void testGetOnEmptyListShouldThrowExceptionWithZeroAsIndex(){
        this.list.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOnEmptyListShouldThrowExceptionWithNegativeIndex(){
        this.list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowExceptionWithIndexOutOfBounds(){
        this.list.add(88);
        this.list.get(1);
    }

    @Test
    public void testGetShouldWorkProperly(){
        this.list.add(55);
        Integer actual = this.list.get(0);
        assertEquals(Integer.valueOf(55), actual);
    }

    // add
    @Test
    public void testAddWorkingCorrectly(){
        this.list.add(13);
        assertTrue(this.list.contains(13));
    }

    // set
    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowException(){
        this.list.set(3, 58);
    }

    @Test
    public void testSetShouldWorkProperly(){
        this.list.add(55);
        this.list.set(0, 44);
        Integer actual = this.list.get(0);
        assertEquals(Integer.valueOf(44), actual);
    }

    // removeAt
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtOutOfBoundsIndex_ThrownException(){
        this.list.add(46);
        this.list.removeAt(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtEmptyList_ThrownException(){
        this.list.removeAt(0);
    }

    @Test
    public void testRemoveAtWorkingCorrectly(){
        this.list.add(13);
        this.list.removeAt(0);
        assertFalse(this.list.contains(13));
    }

    // remove
    @Test
    public void testRemoveReturnsNegativeOneWhenElementIsNotPresent(){
        int actualResult =this.list.remove(0);
        assertEquals(-1, actualResult);
    }

    @Test
    public void testRemoveWorkingCorrectly(){
        this.list.add(13);
        this.list.remove(13);
        assertFalse(this.list.contains(13));
    }

    // indexOf
    @Test
    public void testIndexOfReturnsOnlyFirstOccurrenceOfValue(){
        this.list.add(13);
        this.list.add(42);
        this.list.add(69);
        this.list.add(13);
        assertEquals(list.indexOf(13), 0);
    }

    @Test
    public void testIndexOfReturnsCorrectValue(){
        for (int i = 0; i < 100; i++) {
            this.list.add(i);
        }
        assertEquals(99, this.list.indexOf(99));
    }

    @Test
    public void testIndexOfReturnsNegativeOneIfElementIsNotPresent(){
        assertEquals(-1, this.list.indexOf(12));
    }

    // contains
    @Test
    public void testContainsReturnsFalseOnEmptyList(){
        assertFalse(this.list.contains(13));
    }

    @Test
    public void testContainsReturnsFalseIfElementIsNotPresent(){
        for (int i = 0; i < 210; i++) {
            this.list.add(i);
        }

        assertFalse(this.list.contains(-1));
    }
}