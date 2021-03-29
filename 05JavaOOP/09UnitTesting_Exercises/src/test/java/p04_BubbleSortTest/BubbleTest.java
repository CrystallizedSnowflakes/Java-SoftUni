package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testWhenNotSortedArrayPassedToSort_ThenArraySortedAsc(){
        int[] actualArray = new int[]{5, 14, -2, 20, 32, 0};
        Bubble.sort(actualArray);
        int[] expectedArray = new int[]{-2, 0, 5, 14, 20, 32};

        assertEquals(expectedArray.length, actualArray.length);
        assertArrayEquals(expectedArray, actualArray);
        /*for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }*/
    }

    @Test
    public void testWhenSortedArrayPassedToSort_ThenSameArray(){
        int[] array = new int[]{-2, 0, 5, 14, 20, 32};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-2, 0, 5, 14, 20, 32};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWhenEmptyArrayPassedToSort_ThenEmptyArray(){
        int[] array = new int[]{};
        Bubble.sort(array);
        assertEquals(array.length, 0);
    }
}