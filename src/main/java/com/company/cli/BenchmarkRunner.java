package com.company.cli;

import com.company.algorithms.MinHeap;
import com.company.metrics.PerformanceTracker;
import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {
    private static final String CSV_PATH = "docs/performance-plots/benchmark.csv";
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.println("=== MinHeap Benchmark Runner ===");
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
    }

    private static void runBenchmark(int n, PerformanceTracker tracker) {
        tracker.reset();
        tracker.start();

        MinHeap heap = new MinHeap(tracker);
        for (int i = 0; i < n; i++) {
            heap.insert(random.nextInt(n * 10));
        }
        for (int i = 0; i < n / 2; i++) {
            heap.extractMin();
        }

        tracker.stop();
        tracker.exportToCSV(CSV_PATH, "MinHeap", n);

        System.out.printf("n=%6d | Time: %8.3f ms | Comparisons: %d | Swaps: %d%n",
                n, tracker.getExecutionTimeMs(), tracker.getComparisons(), tracker.getSwaps());
    }
}
