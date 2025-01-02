// Summary and Notes on the Rod Cutting Problem

// Problem Overview
// 	•	Given:
// 	•	A rod of length ￼L.
// 	•	List of possible sizes S￼ we can cut.
// 	•	Corresponding prices ￼ for each size.
// 	•	Goal: Maximize revenue by cutting the rod optimally.

// Key Insights
// 	1.	Optimal Substructure:
// 	•	The problem can be solved recursively by:
// 	•	Making a cut of size ￼, earning ￼.
// 	•	Solving the remaining rod length ￼ optimally.
// 	•	Recurrence Relation:
// ￼
// 	2.	Base Cases:
// 	•	￼: No rod left to cut.
// 	•	￼ for ￼: Invalid case.

// Naive Recursive Implementation
// 	•	Computes the result using a brute-force approach by exploring all possibilities.
// 	•	Major issue: Overlapping subproblems cause exponential growth in time complexity.

// Optimized Approach: Dynamic Programming
// 	1.	Use a DP table to store solutions for subproblems to avoid redundant computations.
// 	2.	Steps:
// 	•	Create an array dp of size ￼ where ￼ stores the maximum revenue for a rod of length ￼.
// 	•	Initialize ￼.
// 	•	For each length ￼ from ￼ to ￼, compute ￼ by considering all possible cuts and their revenues.
// 	•	Return ￼ as the result.

// Pseudocode

// Dynamic Programming Approach

// function maxRevenue(L, sizes, prices):
//     let dp = array of size L+1 initialized to 0
//     for j from 1 to L: // For each rod length
//         maxRev = 0
//         for i from 0 to sizes.length: // Consider each cut
//             if sizes[i] <= j:
//                 maxRev = max(maxRev, prices[i] + dp[j - sizes[i]])
//         dp[j] = maxRev
//     return dp[L]

// Java Implementation

// import java.util.Arrays;

// public class RodCutting {
//     public static double maxRevenue(int L, int[] sizes, double[] prices) {
//         double[] dp = new double[L + 1]; // DP table to store max revenue for each length
//         Arrays.fill(dp, 0); // Initialize to 0 (base case)

//         // Fill the DP table
//         for (int j = 1; j <= L; j++) {
//             double maxRev = 0;
//             for (int i = 0; i < sizes.length; i++) {
//                 if (sizes[i] <= j) { // If the cut size is valid
//                     maxRev = Math.max(maxRev, prices[i] + dp[j - sizes[i]]);
//                 }
//             }
//             dp[j] = maxRev;
//         }

//         return dp[L]; // Return the maximum revenue for length L
//     }

//     public static void main(String[] args) {
//         int L = 100;
//         int[] sizes = {1, 3, 5, 10, 30, 50, 75};
//         double[] prices = {0.1, 0.2, 0.4, 0.9, 3.1, 5.1, 8.2};

//         System.out.println("Maximum Revenue: " + maxRevenue(L, sizes, prices));
//     }
// }

// Explanation
// 	1.	Input: L = 100, sizes = [1, 3, 5, 10, 30, 50, 75], prices = [0.1, 0.2, 0.4, 0.9, 3.1, 5.1, 8.2].
// 	2.	Table:
// 	•	dp[j] is built iteratively by considering each size ￼ and updating the maximum revenue possible for ￼.
// 	3.	Output: Returns the maximum revenue for the rod of length ￼.

    public class RodCutting {

    public static double maxRevenueRecursive(int L, int[] sizes, double[] prices) {
        // Base cases
        if (L == 0) {
            return 0; // No rod left to cut
        }
        if (L < 0) {
            return Double.NEGATIVE_INFINITY; // Invalid case
        }

        // Recurrence relation
        double maxRevenue = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (L >= sizes[i]) { // Valid cut
                maxRevenue = Math.max(maxRevenue, prices[i] + maxRevenueRecursive(L - sizes[i], sizes, prices));
            }
        }

        return maxRevenue;
    }

    public static void main(String[] args) {
        int L = 100;
        int[] sizes = {1, 3, 5, 10, 30, 50, 75};
        double[] prices = {0.1, 0.2, 0.4, 0.9, 3.1, 5.1, 8.2};

        double result = maxRevenueRecursive(L, sizes, prices);
        System.out.println("Maximum Revenue: " + result);
    }
}

--------------------------------------------------

// import java.util.ArrayList;
// import java.util.List;

// public class RodCutting {

//     public static class Result {
//         double maxRevenue;
//         List<String> cuts;

//         public Result(double maxRevenue, List<String> cuts) {
//             this.maxRevenue = maxRevenue;
//             this.cuts = cuts;
//         }
//     }

//     public static Result maxRevenueMemoize(int L, int[] sizes, double[] prices) {
//         int k = sizes.length;
//         assert prices.length == k : "Sizes and prices arrays must have the same length!";

//         // Create tables for storing maximum revenue and solution
//         double[][] tbl = new double[L + 1][k + 1];
//         int[][] sol = new int[L + 1][k + 1];

//         // Fill the tables
//         for (int l = 0; l <= L; l++) {
//             for (int j = k - 1; j >= 0; j--) { // Iterate from k-1 down to 0
//                 int maxCuts = l / sizes[j];
//                 double maxValue = 0;
//                 int bestOption = -1;

//                 for (int i = 0; i <= maxCuts; i++) {
//                     double value = i * prices[j] + tbl[l - i * sizes[j]][j + 1];
//                     if (value > maxValue) {
//                         maxValue = value;
//                         bestOption = i;
//                     }
//                 }

//                 tbl[l][j] = maxValue;
//                 sol[l][j] = bestOption;
//             }
//         }

//         // Retrieve the solution
//         List<String> cuts = new ArrayList<>();
//         int l = L;
//         int j = 0;

//         while (l > 0 && j < k) {
//             int optionId = sol[l][j];
//             if (optionId == -1) break;

//             if (optionId > 0) {
//                 cuts.add("Cut length = " + sizes[j] + ", " + optionId + " times");
//             }

//             l -= optionId * sizes[j];
//             j++;
//         }

//         return new Result(tbl[L][0], cuts);
//     }

//     public static void main(String[] args) {
//         int L = 100;
//         int[] sizes = {1, 3, 5, 10, 30, 50, 75};
//         double[] prices = {0.1, 0.2, 0.4, 0.9, 3.1, 5.1, 8.2};

//         Result result = maxRevenueMemoize(L, sizes, prices);

//         System.out.println("Max Revenue: " + result.maxRevenue);
//         System.out.println("Cuts:");
//         for (String cut : result.cuts) {
//             System.out.println(cut);
//         }
//     }
// }

// // Explanation of the Java Code:
// // 	1.	Inputs:
// // 	•	L: Total length of the rod.
// // 	•	sizes and prices: Arrays representing available sizes and corresponding prices.
// // 	2.	Tables:
// // 	•	tbl[l][j]: Maximum revenue achievable with length l considering sizes from j to the last.
// // 	•	sol[l][j]: Stores the best number of cuts for size sizes[j].
// // 	3.	Algorithm:
// // 	•	Iterate over all lengths l and sizes j.
// // 	•	Calculate the maximum number of cuts possible (maxCuts).
// // 	•	For each possible number of cuts, calculate revenue and update the tables.
// // 	4.	Solution Extraction:
// // 	•	Start from tbl[L][0] and use the sol table to trace back the cuts.
// // 	5.	Output:
// // 	•	Maximum revenue.
// // 	•	List of cuts and how many times each size is used.