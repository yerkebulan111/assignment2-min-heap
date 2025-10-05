package com.company.cli;

import com.company.algorithms.MinHeapSort;
import com.company.metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Command-line benchmark runner for MinHeapSort algorithm.
 * Allows configurable input sizes and exports results to CSV.
 */
public class BenchmarkRunner {

    private static final String CSV_PATH = "docs/performance-plots/benchmark.csv";
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.println("=== MinHeapSort Benchmark Runner ===");
        System.out.print("Enter input sizes (comma separated, e.g. 100,1000,10000): ");
        String input = scanner.nextLine().trim();

        String[] tokens = input.split(",");
        for (String token : tokens) {
            try {
                int size = Integer.parseInt(token.trim());
                runBenchmark(size, tracker);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input size: " + token);
            }
        }

        // without input 10^2 --> 10^5
//        for(int i = 2; i <= 5; i++) {
//            runBenchmark((int) Math.pow(10, i), tracker);
//        }

        System.out.println("\nBenchmarking complete. Results saved to " + CSV_PATH);
    }

    private static void runBenchmark(int n, PerformanceTracker tracker) {
        int[] arr = generateRandomArray(n);

        tracker.reset();
        tracker.start();

        MinHeapSort.sort(arr);

        tracker.stop();
        tracker.exportToCSV(CSV_PATH, "MinHeapSort", n);

        System.out.printf("Input %6d -> Time: %8.3f ms | Comparisons: %d | Swaps: %d%n",
                n, tracker.getExecutionTimeMs(), tracker.getComparisons(), tracker.getSwaps());
    }

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n * 10);
        }
        return arr;
    }
}
