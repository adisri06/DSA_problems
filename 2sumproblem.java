import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int remainder =0;
        for(int i =0 ;i < length ;i++)
        {   
            remainder = target - nums[i];
            for (int j = i+1;j < length;j++)
            {
                if(nums[j] == remainder)
                {
                   
                  return new int[]{i, j};
                
                }
                
            }
            
        }
        return new int[]{};
    }
    
}

//hashmap solution
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), i};
            }
            map.put(nums[i], i);  // Store the index of the current element
        }
        return new int[]{};  // Return an empty array if no solution is found
    }
    
}