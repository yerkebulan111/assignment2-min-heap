package com.company.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapSortTest {

    @Test
    void testNormalCase() {
        int[] arr = {5, 3, 8, 4, 1};
        MinHeapSort.sort(arr);
        int[] expected = {8, 5, 4, 3, 1}; // descending order
        assertArrayEquals(expected, arr, "Normal case should sort array in descending order");
    }

    @Test
    void testAlreadySortedDescending() {
        int[] arr = {9, 7, 5, 3, 1};
        MinHeapSort.sort(arr);
        int[] expected = {9, 7, 5, 3, 1};
        assertArrayEquals(expected, arr, "Already descending array should remain unchanged");
    }

    @Test
    void testAlreadySortedAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        MinHeapSort.sort(arr);
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, arr, "Ascending array should become descending");
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {4, 1, 3, 4, 1};
        MinHeapSort.sort(arr);
        int[] expected = {4, 4, 3, 1, 1};
        assertArrayEquals(expected, arr, "Duplicates should be handled correctly");
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        MinHeapSort.sort(arr);
        int[] expected = {42};
        assertArrayEquals(expected, arr, "Single-element array should remain unchanged");
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        MinHeapSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr, "Empty array should remain unchanged");
    }

    @Test
    void testAllSameElements() {
        int[] arr = {7, 7, 7, 7};
        MinHeapSort.sort(arr);
        int[] expected = {7, 7, 7, 7};
        assertArrayEquals(expected, arr, "Array with all identical elements should remain unchanged");
    }

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> {
            MinHeapSort.sort(null);
        }, "Null array should throw NullPointerException");
    }
}
