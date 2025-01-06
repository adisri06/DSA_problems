
import java.util.Arrays;

public class Knapsack_memoization {
    public int knapSack(int finalWeight, int[] weights, int[]values, int length)
    {
        int[][] table = new int[length][finalWeight + 1];
        for(int[] row: table){
            Arrays.fill(row, -1);
        }
         knapSackutil (0,finalWeight,weights,values,length,table);
         return table[0][finalWeight];
    }
    public int knapSackutil(int currentIndex, int remainingWeight, int[] weights, int[] values,int length, int[][] table){
        //Base case
        if(currentIndex >= length || remainingWeight <=0){
            return 0;
        }
        //recursive case
        if(table[currentIndex][remainingWeight]!= -1){
            return table[currentIndex][remainingWeight];
        }
        int leavecurrent = knapSackutil(currentIndex+1, remainingWeight, weights, values, length, table);
        int takecurrent =0;
        if(weights[currentIndex]<=remainingWeight){
            takecurrent= values[currentIndex] + knapSackutil(currentIndex+1, remainingWeight- weights[currentIndex], weights, values, length, table);
        }
        table[currentIndex][remainingWeight] = Math.max(leavecurrent, takecurrent);
        return table[currentIndex][remainingWeight];
    }
    public static void main(String[] args) {
        Knapsack_memoization obj = new Knapsack_memoization();
        int[] wt1 = {2, 3, 4, 5};
        int[] val1 = {3, 4, 5, 6};
        int W1 = 5;
        System.out.println("Max value (Test Case 1): " + obj.knapSack(W1, wt1, val1, wt1.length)); // Expected: 7

        // Test Case 2
        int[] wt2 = {1, 2, 3};
        int[] val2 = {10, 15, 40};
        int W2 = 5;
        System.out.println("Max value (Test Case 2): " + obj.knapSack(W2, wt2, val2, wt2.length)); // Expected: 55

        // Test Case 3
        int[] wt3 = {10, 20, 30};
        int[] val3 = {60, 100, 120};
        int W3 = 50;
        System.out.println("Max value (Test Case 3): " + obj.knapSack(W3, wt3, val3, wt3.length)); 

        int N4 = 50;
        int W4 = 1000;
        int[] wt4 = new int[N4];
        int[] val4 = new int[N4];
        for (int i = 0; i < N4; i++) {
            wt4[i] = i + 1;   // Weights: [1, 2, 3, ..., 50]
            val4[i] = (i + 1) * 10;  // Values: [10, 20, 30, ..., 500]
        }
        System.out.println("Max value (Test Case 4): " + obj.knapSack(W4, wt4, val4, N4)); // Expected: High value

        // Test Case 5: All items too heavy
        int[] wt5 = {100, 200, 300, 400, 500};
        int[] val5 = {1000, 2000, 3000, 4000, 5000};
        int W5 = 50;
        System.out.println("Max value (Test Case 5): " + obj.knapSack(W5, wt5, val5, wt5.length)); // Expected: 0

        // Test Case 6: All items fit exactly
        int[] wt6 = {100, 200, 300, 400};
        int[] val6 = {1000, 2000, 3000, 4000};
        int W6 = 1000;
        System.out.println("Max value (Test Case 6): " + obj.knapSack(W6, wt6, val6, wt6.length)); // Expected: 10000
    }

}
