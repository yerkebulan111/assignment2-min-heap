package com.company.algorithms;

import com.company.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapSortTest {

    @Test
    void testNormalCase() {
        int[] arr = {5, 3, 8, 4, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {8, 5, 4, 3, 1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySortedDescending() {
        int[] arr = {9, 7, 5, 3, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {9, 7, 5, 3, 1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySortedAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {4, 1, 3, 4, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {4, 4, 3, 1, 1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {42};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAllSameElements() {
        int[] arr = {7, 7, 7, 7};
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeapSort.sort(arr, tracker);
        int[] expected = {7, 7, 7, 7};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testNullArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(NullPointerException.class, () -> MinHeapSort.sort(null, tracker));
    }
}
