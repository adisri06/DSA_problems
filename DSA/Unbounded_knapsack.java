public class Unbounded_knapsack {

    public static int knapSack(int length,int finalWeight, int[] values,int[] weights){
        int[][] dp = new int[length+1][finalWeight+1];
        for(int i=1;i< length+1;i++){

            for(int j=1;j<finalWeight+1;j++){
                if(weights[i-1]<=j){
                    dp[i][j] = Math.max(values[i-1]+dp[i][j-weights[i-1]],dp[i-1][j]);
                    //only i-1  changed to i  is changed in unbounded knapsack
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[length][finalWeight];
    }
    public static void main(String[] args) {
        // Test Cases
        int[][] weights = {
            {1, 3, 4, 5}, {2, 2, 3}, {3, 4, 6}, {5, 10, 15}, {1, 2, 3, 4}, 
            {1, 3, 5}, {2, 5, 10}, {2, 4, 6, 8}, {3, 7, 10}, {1, 5, 10, 20}
        };
        int[][] values = {
            {10, 40, 50, 70}, {20, 30, 50}, {30, 40, 60}, {50, 100, 150}, {10, 20, 30, 40}, 
            {5, 10, 15}, {20, 50, 100}, {10, 20, 30, 40}, {15, 35, 50}, {5, 25, 50, 100}
        };
        int[] capacities = {8, 5, 10, 20, 7, 6, 15, 12, 9, 30};
        int[] sizes = {4, 3, 3, 3, 4, 3, 3, 4, 3, 4};

        for (int i = 0; i < 10; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + knapSack(sizes[i], capacities[i], values[i], weights[i]));
        }
    }
}
