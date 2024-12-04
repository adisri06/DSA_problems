class Solution {
    public String mergeAlternately(String word1, String word2) {
        int lenfirst=  word1.length();
        int lensecond= word2.length();
        StringBuilder finalword = new StringBuilder();
        int looplen = Math.min(lenfirst, lensecond);
        for (int i = 0; i < looplen; i++)
        {
            finalword.append(word1.charAt(i));
            finalword.append(word2.charAt(i));
        }
        finalword.append((lenfirst > lensecond ) ? word1.substring(looplen , lenfirst) : word2.substring(looplen , lensecond)) ;

        return finalword.toString();
    }
}

// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
//     starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

// Return the merged string.

