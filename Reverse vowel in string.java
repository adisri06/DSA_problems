class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        HashMap<Integer, Character> map = new HashMap<>();
        HashMap<Integer, Character> dupmap = new HashMap<>();
        for (int i = 0; i < s.length() ;i++)
        {
            if(vowel.indexOf(s.charAt(i)) >= 0)
            {
                map.put(i,s.charAt(i));
            }

        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        List<Character> values = new ArrayList<>(map.values());
         System.out.print("keys" + keys); 
         Collections.sort(keys);

        Collections.reverse(values);
         System.out.print("\nreverse keys" + keys); 


        for (int i =0;i < keys.size() ;i++)
        {    

            dupmap.put(keys.get(i),values.get(i));
        }   
             System.out.print("\nright "+ map); 
             System.out.print("\nrevers" + dupmap); 

        for (Map.Entry<Integer, Character> entry : dupmap.entrySet()) {
                              


            s = s.substring(0, entry.getKey()) + entry.getValue()
              + s.substring(entry.getKey() + 1);

        }

        return s;
        }

    }

//POINTER METHODS OF CHATGPT
// class Solution {
//     public String reverseVowels(String s) {
//         String vowel = "aeiouAEIOU";
        
//     int left = 0;
//         int right = s.length() - 1;
//         char[] chars = s.toCharArray();


//         while (left < right) {
//             while(left < right && !(vowel.indexOf(s.charAt(left)) >= 0 )){
//                 left++;
//             }
//             while(left < right && !(vowel.indexOf(s.charAt(right)) >= 0 )){
//                 right--;
//             }
//             if (left < right) {
//                    char temp = chars[left];
//                     chars[left] = chars[right];
//                     chars[right] = temp;
//                 left++;
//                 right--;
//             }
//         }
//         return new String(chars);
//     }

//     }


// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"
