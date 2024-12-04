class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String a ="";
        for(int i=words.length -1 ;i>0;i--)
        {
            a+=words[i]+" ";
        }
        a+= words[0];
        return a ;
    }
}
