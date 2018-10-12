class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int countAlpha[] = new int[27];
        for(int i = 0; i < s.length(); i++) {
            countAlpha[s.charAt(i) - 96]++ ;
        }
        for(int i = 0; i < t.length(); i++) {
            if(countAlpha[t.charAt(i) - 96] > 0) {
                countAlpha[t.charAt(i) - 96]--;
            } else {
                return false;
            }
        }
        for(int i = 1; i < 27; i++) {
            if(countAlpha[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution { //Inefficient
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        

        //Better way to check arrays are equal or not
        // for(int i = 0; i < ch1.length; i++) {
        //     if(ch1[i] != ch2[i])
        //         return false;
        // }
        // return true;
        
        return Arrays.equals(ch1, ch2);
        
    }
}

/***

What if the inputs contain unicode characters? How would you adapt your solution to such case?
Answer: Use a hash table instead of a fixed size counter.

***/

