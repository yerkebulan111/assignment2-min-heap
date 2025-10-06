package com.company.algorithms;

import com.company.metrics.PerformanceTracker;
import java.util.ArrayList;
import java.util.List;

/**
 * Min-Heap data structure implementation with decrease-key and merge operations.
 * Instrumented using PerformanceTracker for comparisons, swaps, array accesses, and memory allocations.
 */
public class MinHeap {
    private final List<Integer> heap;
    private final PerformanceTracker tracker;

    public MinHeap(PerformanceTracker tracker) {
        this.heap = new ArrayList<>();
        this.tracker = tracker;
        tracker.incMemoryAllocations();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    /** Insert a new key into the heap */
    public void insert(int key) {
        tracker.incMemoryAllocations();
        heap.add(key);
        tracker.incArrayAccesses();
        heapifyUp(heap.size() - 1);
    }

    /** Extract and return the minimum element */
    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int root = heap.get(0);
        tracker.incArrayAccesses();

        int last = heap.remove(heap.size() - 1);
        tracker.incArrayAccesses();
        if (!heap.isEmpty()) {
            heap.set(0, last);
            tracker.incArrayAccesses();
            heapifyDown(0);
        }
        return root;
    }

    /** Decrease key at a specific index */
    public void decreaseKey(int i, int newKey) {
        if (i < 0 || i >= heap.size()) throw new IllegalArgumentException("Invalid index");
        tracker.incComparisons();
        if (newKey > heap.get(i)) throw new IllegalArgumentException("New key is larger than current key");

        heap.set(i, newKey);
        tracker.incArrayAccesses();
        heapifyUp(i);
    }

    /** Merge two heaps into the current one */
    public void merge(MinHeap other) {
        for (int key : other.heap) {
            tracker.incArrayAccesses();
            insert(key);
        }
    }

    /** Internal helper: heapify up */
    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            tracker.incComparisons();
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /** Internal helper: heapify down */
    private void heapifyDown(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < heap.size()) {
            tracker.incComparisons();
            tracker.incArrayAccesses();
            if (heap.get(l) < heap.get(smallest)) smallest = l;
        }
        if (r < heap.size()) {
            tracker.incComparisons();
            tracker.incArrayAccesses();
            if (heap.get(r) < heap.get(smallest)) smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        tracker.incSwaps();
        tracker.incArrayAccesses();
    }

    public List<Integer> toList() {
        return new ArrayList<>(heap);
    }
}





/*

package com.company.algorithms;

public class MinHeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // heapify the affected subtree
            heapify(arr, n, smallest);
        }
    }

}
 */