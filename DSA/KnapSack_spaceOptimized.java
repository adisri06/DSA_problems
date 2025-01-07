public class KnapSack_spaceOptimized {
    public static int knapSack (int finalWeight, int[] weight, int[] value, int length){
        int[] prev = new int[finalWeight+1];
        int[] curr = new int[finalWeight+1];
        prev[0]= curr[0] = 0;
        for(int i =1;i< length+1;i++){
            for(int j =1;j< finalWeight+1;j++){
                
                int exclude = prev[j];
                int include = (weight[i-1]<=j)? value[i-1]+prev[j-weight[i-1]]:0;
                curr[j] = Math.max(include, exclude);
            }
            prev = curr.clone(); // arrays copy by reference so we need to clone it
        }
        return curr[finalWeight];
    }
    public static void main(String[] args) {
        // ✅ Test Case 1: Basic Example
        int[] wt1 = {2, 3, 4, 5};
        int[] val1 = {3, 4, 5, 6};
        int W1 = 5;
        System.out.println("Max value (Test 1): " + knapSack(W1, wt1, val1, wt1.length)); // Expected: 7

        // ✅ Test Case 2: Small Weights
        int[] wt2 = {1, 2, 3};
        int[] val2 = {10, 15, 40};
        int W2 = 5;
        System.out.println("Max value (Test 2): " + knapSack(W2, wt2, val2, wt2.length)); // Expected: 55

        // ✅ Test Case 3: All Items Fit
        int[] wt3 = {1, 2, 3, 4, 5};
        int[] val3 = {10, 20, 30, 40, 50};
        int W3 = 15;
        System.out.println("Max value (Test 3): " + knapSack(W3, wt3, val3, wt3.length)); // Expected: 150 (All included)

        // ✅ Test Case 4: Single Item Fits
        int[] wt4 = {5, 10, 15};
        int[] val4 = {10, 20, 30};
        int W4 = 10;
        System.out.println("Max value (Test 4): " + knapSack(W4, wt4, val4, wt4.length)); // Expected: 20 (Only 10 weight item)

        // ✅ Test Case 5: Only One Item Possible
        int[] wt5 = {2, 3, 4, 5};
        int[] val5 = {3, 4, 5, 6};
        int W5 = 2;
        System.out.println("Max value (Test 5): " + knapSack(W5, wt5, val5, wt5.length)); // Expected: 3

        // ✅ Test Case 6: Edge Case (No Items)
        int[] wt6 = {};
        int[] val6 = {};
        int W6 = 10;
        System.out.println("Max value (Test 6): " + knapSack(W6, wt6, val6, wt6.length)); // Expected: 0

        // ✅ Test Case 7: Edge Case (Zero Capacity)
        int[] wt7 = {1, 2, 3};
        int[] val7 = {10, 15, 40};
        int W7 = 0;
        System.out.println("Max value (Test 7): " + knapSack(W7, wt7, val7, wt7.length)); // Expected: 0

        // ✅ Test Case 8: Large Test Case (50 Items, Large Capacity)
        int N8 = 50;
        int W8 = 1000;
        int[] wt8 = new int[N8];
        int[] val8 = new int[N8];
        for (int i = 0; i < N8; i++) {
            wt8[i] = i + 1;  // Weights: [1, 2, 3, ..., 50]
            val8[i] = (i + 1) * 10;  // Values: [10, 20, 30, ..., 500]
        }
        System.out.println("Max value (Test 8 - Large): " + knapSack(W8, wt8, val8, N8)); // Expected: High value

        // ✅ Test Case 9: Large Capacity, Small Items
        int[] wt9 = {1, 1, 1, 1, 1};
        int[] val9 = {1, 1, 1, 1, 1};
        int W9 = 100;
        System.out.println("Max value (Test 9): " + knapSack(W9, wt9, val9, wt9.length)); // Expected: 5 (Only 5 items exist)

        // ✅ Test Case 10: Single Large Item
        int[] wt10 = {100};
        int[] val10 = {500};
        int W10 = 50;
        System.out.println("Max value (Test 10): " + knapSack(W10, wt10, val10, wt10.length)); // Expected: 0 (Item too big)
    }
}
