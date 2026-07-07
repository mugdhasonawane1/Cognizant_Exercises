# Exercise 7: Financial Forecasting

## 1. Understand Recursive Algorithms
Recursion is a programming technique where a method calls itself to solve a smaller instance of the same problem. Recursion simplifies problems that can be naturally divided into similar sub-problems (like tree traversals, calculating factorials, or projecting compounding periods). By defining a "base case" (when to stop) and a "recursive step" (how to progress to the base case), we avoid writing complex loops and state-tracking code, leading to cleaner, more mathematical representations of algorithms.

## 4. Analysis

### Time Complexity
- **Standard Recursion (`predictFutureValue`)**: The time complexity is **O(n)**, where `n` is the number of periods. For every period, we make exactly one recursive call until the base case (`periods == 0`) is reached. The space complexity is also **O(n)** due to the call stack depth.

### Optimization to avoid excessive computation
- **Exponentiation by Squaring (`calculateGrowthMultiplier`)**: 
  Instead of multiplying `(1 + growthRate)` sequentially `n` times, we can optimize this heavily. Recognizing that `(1 + r)^n` can be broken down into `( (1+r)^{n/2} )^2`, we can halve the problem size at each step.
  This optimized recursive approach avoids excessive computation, dropping the time complexity to **O(log n)** and the space complexity (call stack depth) to **O(log n)**. This is a crucial algorithmic optimization when projecting forecasts across thousands or millions of tiny intervals (e.g., compounding every second for several years).
