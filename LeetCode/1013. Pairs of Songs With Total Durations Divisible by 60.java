class Solution {
    public int numPairsDivisibleBy60(int[] time) {
                        
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
        
    }
}

/**
Reference: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256738/JavaC++Python-Two-Sum-with-K-60?orderBy=most_votes

*/