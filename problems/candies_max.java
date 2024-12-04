class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =candies[0];
 ArrayList<Boolean> arr = new ArrayList<>();       
  for (int i=0;i<candies.length;i++)
        {
            if(candies[i]> max)
            {
                max = candies[i];
            }
        }
        for (int i=0;i<candies.length;i++)
        {
            if(candies[i]+ extraCandies >= max)
            {
               arr.add(true);
            }
            else
            {
                arr.add(false);
            }
        }
        return arr;
    // Arrays.sort(candies, Collections.reverseOrder());


    }
 }
// Overview
// We are given an integer array candies, where each candies[i] represents the number of candies the i 
// th
//   kid has, and an integer extraCandies, denoting the number of extra candies that you have.

// Our task is to return a boolean array result of length n, where result[i] is true if, after giving the i 
// th
//   kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
