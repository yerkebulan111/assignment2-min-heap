package com.company.algorithms;

import com.company.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void testInsertAndExtract() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap = new MinHeap(tracker);
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testDecreaseKey() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap = new MinHeap(tracker);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.decreaseKey(2, 5);
        assertEquals(5, heap.extractMin());
    }

    @Test
    void testMerge() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap1 = new MinHeap(tracker);
        MinHeap heap2 = new MinHeap(tracker);

        heap1.insert(3);
        heap1.insert(7);
        heap2.insert(1);
        heap2.insert(5);

        heap1.merge(heap2);
        assertEquals(1, heap1.extractMin());
        assertEquals(3, heap1.extractMin());
        assertEquals(5, heap1.extractMin());
        assertEquals(7, heap1.extractMin());
    }

    @Test
    void testEmptyExtractThrows() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap = new MinHeap(tracker);
        assertThrows(IllegalStateException.class, heap::extractMin);
    }
}
