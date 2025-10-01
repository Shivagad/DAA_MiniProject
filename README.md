# Mini Projects in Multithreaded Programming (Java)

## 📌 Overview
This repository contains two mini projects that demonstrate the use of **multithreading in Java** and compare it with single-threaded implementations:

1. **Matrix Multiplication**
2. **Merge Sort**

Both projects allow user input, perform operations in normal and multithreaded ways, and compare execution times. Performance analysis is also included for best, worst, and average cases.

---

## 📂 Project Structure
```
MiniProjects/
├── MatrixMultiplicationProject/
│   ├── MatrixMultiplication.java   # Normal matrix multiplication
│   ├── RowMultiplierThread.java    # Thread per row multiplication
│   ├── CellMultiplierThread.java   # Thread per cell multiplication
│   └── Main.java                   # Driver program with user input
│
└── MergeSort/
    ├── MergeSort.java              # Normal merge sort implementation
    ├── MergeSortThread.java        # Multithreaded merge sort implementation
    └── Main.java                   # Driver program with user input
```

---

## ⚡ How to Run

### 1. Matrix Multiplication
1. Navigate to the folder:
   ```bash
   cd MatrixMultiplicationProject
   ```
2. Compile:
   ```bash
   javac *.java
   ```
3. Run:
   ```bash
   java Main
   ```

#### ✅ Sample Input
```
Enter number of rows for Matrix A: 2
Enter number of columns for Matrix A: 2
Enter number of rows for Matrix B: 2
Enter number of columns for Matrix B: 2
Enter elements of Matrix A:
1 2
3 4
Enter elements of Matrix B:
5 6
7 8
```

#### 📤 Sample Output
```
Normal Multiplication Time: 1 ms
Thread per Row Multiplication Time: 0 ms
Thread per Cell Multiplication Time: 2 ms

Result Matrix (Normal Multiplication):
19 22
43 50
```

---

### 2. Merge Sort
1. Navigate to the folder:
   ```bash
   cd MergeSort
   ```
2. Compile:
   ```bash
   javac *.java
   ```
3. Run:
   ```bash
   java Main
   ```

#### ✅ Sample Input
```
Enter size of array: 6
Enter 6 elements of the array:
8 3 1 9 5 2
```

#### 📤 Sample Output
```
Normal Merge Sort Time: 1 ms
Multithreaded Merge Sort Time: 2 ms

Sorted Array (Normal Merge Sort):
1 2 3 5 8 9
```

---

## 📊 Performance Analysis

### 🔹 Matrix Multiplication
| Method                 | Description                                                                 | Time Complexity | Observations                                                                                     |
|------------------------|-----------------------------------------------------------------------------|----------------|-------------------------------------------------------------------------------------------------|
| **Normal (Single-threaded)** | Standard iterative multiplication of two matrices.                           | O(n³)          | Low overhead. Efficient for small to medium matrices.                                           |
| **Thread per Row**      | Each row is computed in a separate thread.                                   | O(n³)          | Balanced approach. Shows performance improvement on multi-core CPUs. Suitable for medium-large matrices. |
| **Thread per Cell**     | Each cell is computed in a separate thread.                                  | O(n³)          | High thread creation overhead. Often slower than single-threaded for small/medium matrices. Works only for very large matrices with optimized thread management. |

**Notes on Timing:**  
- Small matrices (e.g., 2×2, 5×5): single-threaded is faster due to minimal overhead.  
- Medium matrices (e.g., 100×100): thread-per-row may start showing speedup.  
- Large matrices (e.g., 1000×1000): thread-per-cell is usually inefficient unless thread creation is optimized.

### 🔹 Merge Sort
| Method                     | Description                                                     | Time Complexity       | Observations                                                                                     |
|----------------------------|-----------------------------------------------------------------|---------------------|-------------------------------------------------------------------------------------------------|
| **Normal Merge Sort**       | Recursive divide-and-conquer sorting in a single thread.        | O(n log n)          | Consistent performance across best, worst, and average cases. Efficient for small to medium arrays. |
| **Multithreaded Merge Sort** | Uses separate threads for recursive halves.                     | O(n log n)          | Thread creation overhead may make it slower for small arrays. Benefit only appears for very large arrays on multi-core CPUs. |

**Case Analysis:**
- **Best Case (Already Sorted Array):** Both methods perform O(n log n). Multithreaded version may be slower due to thread overhead.  
- **Worst Case (Reverse Sorted Array):** Both still O(n log n), but multithreading can reduce wall-clock time for very large arrays.  
- **Average Case (Random Array):** Performance similar to worst case; benefits of multithreading are more noticeable with larger input sizes.

**Notes on Timing:**  
- Small arrays (<10⁴ elements): normal merge sort is faster.  
- Large arrays (>10⁵ elements) on multi-core CPUs: multithreaded merge sort can be faster if threads are properly managed (thread pool or limited recursion levels).  

---

## 📝 Conclusion
- Multithreading does not **always guarantee faster execution**. For small arrays or matrices, the overhead of thread creation and context switching can outweigh benefits.  
- **Matrix Multiplication:** Per-row multithreading provides a practical speedup on medium to large matrices. Per-cell threading is generally inefficient due to excessive threads.  
- **Merge Sort:** Single-threaded merge sort is better for small arrays. Multithreaded merge sort benefits appear only for very large arrays and require optimization (e.g., thread pool or thresholding recursion).  
- **General Insight:** The tradeoff between **parallelism** and **thread management overhead** must be carefully considered when implementing multithreaded algorithms in Java.  

---
