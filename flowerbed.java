class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        Boolean flag = true;
        if((flowerbed.length  ==1 && flowerbed[0] ==0 )|| n ==0 )
        {
            return true;
        }
        if(flowerbed.length  ==1 && flowerbed[0] ==1  && n>0)
        {
            return false;
        }
        if(flowerbed[0] == 0 && flowerbed[1]==0 )
        {
            n--;
            flowerbed[0] = 1;
        }
        for (int i=1;i<flowerbed.length - 2;i++)
        {
            if (flowerbed[i-1] ==0 && flowerbed[i] ==0 && flowerbed[i+1] ==0 && n > 0)
            {
                n--;
                flowerbed[i] = 1;
            }

        }
        if(flowerbed[flowerbed.length -2 ] == 0 && flowerbed[flowerbed.length -1]==0 && n > 0)
        {
            n--;
            flowerbed[flowerbed.length -1 ] = 1;
        }
        if(n==0)
        {
            flag = true;
        }
        else
        {
            flag = false;
        }
        return flag;
    }
}


// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

// Example 1:

// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true
// Example 2:

// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
