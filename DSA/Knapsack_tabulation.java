public class Knapsack_tabulation {

    // Test Case 1
    public static int knapSack(int finalWeight, int[] weights, int[] values, int length){
        int[][] table = new int[length+1][finalWeight+1];
        for (int i=0;i< length+1;i++){
           table[i][0]=0;
        }
        for (int i=0;i< finalWeight+1;i++){
            table[0][i]=0;
         }

         for(int i=1;i<length+1;i++){
            for(int j=1;j<finalWeight+1;j++){
                if(weights[i-1]<=j){
                    table[i][j]= Math.max(values[i-1]+ table[i-1][j-weights[i-1]], table[i-1][j]);
                }
                else{
                    table[i][j]= table[i-1][j];

                }
                }
            }
            return table[length][finalWeight];
         }
  public static void main(String[] args) {
    // Test Case 1
    int[] wt1 = {2, 3, 4, 5};
    int[] val1 = {3, 4, 5, 6};
    int W1 = 5;
    System.out.println("Max value (Test Case 1): " + knapSack(W1, wt1, val1, wt1.length)); // Expected: 7

    // Test Case 2
    int[] wt2 = {1, 2, 3};
    int[] val2 = {10, 15, 40};
    int W2 = 5;
    System.out.println("Max value (Test Case 2): " + knapSack(W2, wt2, val2, wt2.length)); // Expected: 55

    // Large Test Case 3
    int N3 = 50;
    int W3 = 1000;
    int[] wt3 = new int[N3];
    int[] val3 = new int[N3];
    for (int i = 0; i < N3; i++) {
        wt3[i] = i + 1;   // Weights: [1, 2, 3, ..., 50]
        val3[i] = (i + 1) * 10;  // Values: [10, 20, 30, ..., 500]
    }
    System.out.println("Max value (Test Case 3): " + knapSack(W3, wt3, val3, N3)); // Expected: High value
}
}
