/***
Running time: O(N) where N = length of String
***/

class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int length = s.length() - 1;
        for(int i = 0; i< s.length() ; i++) {
            ans += (s.charAt(i) - 64) * Math.pow(26,(length--)); 
        } 
        
       return ans;
    }
}

 