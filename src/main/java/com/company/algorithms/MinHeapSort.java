package com.company.algorithms;

import com.company.metrics.PerformanceTracker;

/**
 * Min-Heap based heapsort with a small-size cutoff using insertion sort.
 * Instrumented with PerformanceTracker (comparisons, swaps, array accesses, memory allocations).
 *
 * Note: This implementation produces a descending order result since it builds a min-heap
 * and repeatedly places the minimum at the end. If you want ascending order, adjust accordingly.
 */
public class MinHeapSort {

    private static final int CUTOFF = 10; // threshold for insertion sort

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new NullPointerException("Input array is null");
        if (tracker == null) throw new IllegalArgumentException("PerformanceTracker must not be null");

        int n = arr.length;

        tracker.incMemoryAllocations();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, tracker);
        }

        // Extract elements one by one and put the min at the end -> descending order
        for (int i = n - 1; i > 0; i--) {
            tracker.incArrayAccesses();
            tracker.incArrayAccesses();
            int temp = arr[0];
            arr[0] = arr[i];
            tracker.incArrayAccesses();
            arr[i] = temp;
            tracker.incArrayAccesses();
            tracker.incSwaps();

            heapify(arr, i, 0, tracker); // heapify reduced heap
        }
    }

    private static void heapify(int[] arr, int n, int i, PerformanceTracker tracker) {
        // If segment small, use insertion sort as optimization
        if (n <= CUTOFF) {
            insertionSort(arr, n, tracker);
            return;
        }

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Access arr[i] once for baseline
        tracker.incArrayAccesses();

        if (left < n) {
            tracker.incArrayAccesses();
            tracker.incArrayAccesses();
            tracker.incComparisons();
            if (arr[left] < arr[smallest]) {
                smallest = left;
            }
        }

        if (right < n) {
            tracker.incArrayAccesses();
            tracker.incArrayAccesses();
            tracker.incComparisons();
            if (arr[right] < arr[smallest]) {
                smallest = right;
            }
        }

        if (smallest != i) {
            tracker.incArrayAccesses();
            tracker.incArrayAccesses();
            int temp = arr[i];
            arr[i] = arr[smallest];
            tracker.incArrayAccesses();
            arr[smallest] = temp;
            tracker.incArrayAccesses();
            tracker.incSwaps();

            heapify(arr, n, smallest, tracker);
        }
    }

    private static void insertionSort(int[] arr, int n, PerformanceTracker tracker) {
        for (int i = 1; i < n; i++) {
            tracker.incArrayAccesses();
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                tracker.incArrayAccesses();
                tracker.incComparisons();
                if (arr[j] > key) {
                    tracker.incArrayAccesses();
                    arr[j + 1] = arr[j];
                    tracker.incArrayAccesses();
                    tracker.incSwaps();
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            tracker.incArrayAccesses();
        }
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