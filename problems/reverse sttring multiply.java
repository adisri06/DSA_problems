class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] answer = new int[n];
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
             System.out.print("\nleft products of " + i +"  " + leftProducts[i]); 

        }
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
            System.out.print("\nrightProducts of " + i +"  " + rightProducts[i]); 
}
        for (int i = 0; i < n; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
            System.out.print("\nanswer of " + i +"  " + answer[i]); 

        
        

        }
                return answer;
        
    }
}

// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4] 
// Output: [24,12,8,6]
// leftproduct[0] = 1
// leftproduct[1] = 1 * nums[0 = 1] = 1
// leftproduct[2] = 2 * nums[1 = 2] = 2
// leftproduct[3] = 2 * nums[2 = 3] = 6

// rightProducts[3] = 1
// rightproduct[2] = 1 * nums[3 =4] = 4
// rightproductproduct[1] = 4 * nums[3] = 12
// rightproduct[0] = 12 * nums[1] = 24

// answer [0] = 24 * 1 = 24
// answer[1] = 12 *1 =12
// answer[2] = 4 *2 = 8
// answwer[4] = 3 * 2 = 6


// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
