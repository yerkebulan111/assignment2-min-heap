# Assignment 2 — Design and Analysis of Algorithms
## Pair 4: Heap Data Structures
### Student A — Min-Heap Implementation

---

### Overview
This project implements the **Min-Heap** data structure as part of the *Design and Analysis of Algorithms* course assignment.  
The heap supports fundamental operations such as insertion, extraction of the minimum element, key decrease, and merging of two heaps.

The implementation also integrates **performance metrics** tracking and **benchmarking CLI** to analyze runtime behavior and operation counts for various input sizes.

---

### Project Structure
```
assignment2-min-heap/

├── .github/
│   └── workflows/
│       └── maven.yml

├── .idea/
├── .mvn/

├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
│       └── benchmark.csv

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/company/
│   │   │       ├── algorithms/
│   │   │       │   └── MinHeap.java
│   │   │       ├── cli/
│   │   │       │   └── BenchmarkRunner.java
│   │   │       └── metrics/
│   │   │           └── PerformanceTracker.java
│   │   └── resources/
│
│   └── test/
│       └── java/
│           └── com/company/algorithms/
│               └── MinHeapTest.java

├── target/

├── .gitignore
├── pom.xml
└── README.md


```


---

###  Features Implemented

| Commit | Description |
|--------|--------------|
| `init` | Maven project setup with JUnit 5 and CI configuration |
| `feat(metrics)` | Added performance counters and CSV export |
| `feat(algorithm)` | Implemented baseline Min-Heap structure |
| `test(algorithm)` | Added comprehensive JUnit test suite with edge cases |
| `feat(cli)` | Added CLI benchmark runner with configurable input sizes |
| `feat(optimization)` | Added optimized heap operations and code refactor |
| `docs(readme)` | Added project usage instructions and complexity analysis |
| | |
---

###  How to Build and Run

This project uses **Apache Maven**.


#### Prerequisites:
- Java JDK 25 or higher
 - Apache Maven


#### Project Build:
In the root directory run:
```bash
mvn clean package

```
This will compile the source code, run the tests, and create an executable .jar file in the target/ directory

---

### How to Run the Benchmark CLI

#### You can run the benchmarks for min-heap algorithm with different input sizes. Input sizes must be integer ! (>0)

```
java -jar target/daa-assignment2.jar --algo [algorithm-name] --sizes [array-sizes]
```

 - **[algoritm-name]** - Algoritm name (minheap)
 - **[array-sizes]** - array sizes, you can give one size or multiple sizes at once. Note that array sizes must be integer (>0)

**Example:**
```
java -jar target/daa-assignment2.jar --algo minheap --sizes 1000,10000,50000
```

Algoritm sizes: 1000,10000,50000

Algorithm will be executed in 3 different sizes 


#### After Run:

After running benchmarks, a CSV file `benchmark.csv` will be created in the `docs/performance-plots/` directory.

---

### Run Tests

To run unit tests (executes all **JUnit 5** test cases):

```bash
mvn test
```

---

### Analysis Report

A detailed theoretical and empirical analysis of the Max-Heap implementation, including complexity derivations, code review, and performance plots, can be found at:
```
docs/analysis-report.pdf
```

---

