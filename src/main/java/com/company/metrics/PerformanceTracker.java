package com.company.metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

/**
 * Tracks algorithm performance metrics such as comparisons,
 * swaps, array accesses, and memory allocations.
 */
public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long memoryAllocations = 0;
    private long startTime;
    private long endTime;


    public void start() {
        startTime = System.nanoTime();
    }


    public void stop() {
        endTime = System.nanoTime();
    }


    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incArrayAccesses() { arrayAccesses++; }
    public void incMemoryAllocations() { memoryAllocations++; }


    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getMemoryAllocations() { return memoryAllocations; }
    public double getExecutionTimeMs() { return (endTime - startTime) / 1_000_000.0; }


    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
        startTime = 0;
        endTime = 0;
    }

    /**
     * Export performance data to a CSV file.
     * @param filePath output CSV path (e.g. "docs/performance.csv")
     * @param algorithmName name of algorithm being tested
     * @param inputSize size of input array
     */

    public void exportToCSV(String filePath, String algorithmName, int inputSize) {
        try {
            java.io.File file = new java.io.File(filePath);
            file.getParentFile().mkdirs(); // ensures the directory exists

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.append(String.format(Locale.US,"%s,%d,%d,%d,%d,%d,%.3f%n",
                        algorithmName, inputSize, comparisons, swaps, arrayAccesses,
                        memoryAllocations, getExecutionTimeMs()));
            }
        } catch (IOException e) {
            System.err.println("Error writing performance data to CSV: " + e.getMessage());
        }
    }


//    public void exportToCSV(String filePath, String algorithmName, int inputSize) {
//        try (FileWriter writer = new FileWriter(filePath, true)) {
//            writer.append(String.format("%s,%d,%d,%d,%d,%d,%.3f%n",
//                    algorithmName, inputSize, comparisons, swaps, arrayAccesses,
//                    memoryAllocations, getExecutionTimeMs()));
//        } catch (IOException e) {
//            System.err.println("Error writing performance data to CSV: " + e.getMessage());
//        }
//    }
}
