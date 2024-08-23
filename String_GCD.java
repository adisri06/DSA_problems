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
}}
