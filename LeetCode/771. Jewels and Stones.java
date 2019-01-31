/***
Brute way: O(S*J)

Linear Solution: O(S+J)
***/

class Solution {
    public int numJewelsInStones(String j, String s) {
        
        int count = 0;
        int[] a = new int[255];
        for (int i = 0; i < j.length(); i++)
            a[j.charAt(i)] += 1;
        
        for (int i = 0; i < s.length(); i++)
            if (a[s.charAt(i)] > 0) {
                count++;
            }
        
        return count;
    }
}