class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int str1len = str1.length();
        int str2len =str2.length();
        String finalstring = "";
        if (!(str1 + str2 ).equals(str2 + str1))
        {
        return finalstring;
        
    }
    while (str2len != 0) {
            int temp = str2len ;
            str2len  = str1len  % str2len ;
            str1len  = temp;
        }

        return (str1.substring(0, str1len));

//Replace method of a string
    //      if ((str1 + str2 ).equals(str2 + str1))
    //     {
    //      for (int i = Math.min(str1len,str2len); i >=1; --i)
    // {
    //     if(str1.replace(str1.substring(0,i),"").isEmpty() && str2.replace(str1.substring(0,i),"").isEmpty() )
    //     {
    //         return str1.substring(0,i);
    //     }
    // }
        
    // }
}}


// For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""
 

// Constraints:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of English uppercase letters.
