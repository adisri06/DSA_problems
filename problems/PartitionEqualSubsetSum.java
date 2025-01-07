public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {  // Summing all elements
            total += num;
        }

        // If total sum is odd, we can't partition into two equal subsets
        if (total % 2 != 0) return false;
        int length = total / 2;

        boolean[] prev = new boolean[length + 1];
        boolean[] curr = new boolean[length + 1];

        // Base case: Sum 0 is always achievable
        prev[0] = curr[0] = true;

        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            for (int j = length; j >= 1; j--) {  // Iterate in reverse to prevent overwriting
                curr[j] = nums[i - 1] <= j ? prev[j - nums[i - 1]] : false;
                curr[j] = curr[j] || prev[j];
            }
            prev = curr.clone();
        }

        return curr[length];
    }

    public static void main(String[] args) {
        // Hardcoded input
        int[] nums = {1, 5, 11, 5};  

        // Function call and output
        boolean result = canPartition(nums);
        System.out.println("Can partition: " + result);
    }
}