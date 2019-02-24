public class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[n] = 1; // Empty string one way
        dp[n-1] = s.charAt(n - 1) != '0' ? 1 : 0; // One character one way if not zero
        
        for (int i = n - 2; i >= 0; i--)
            if ( s.charAt(i) == '0' ) continue; // if zero skip
            else dp[i] = Integer.parseInt( s.substring(i, i + 2) ) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1]; // if <= 26 add dp of last 2 or last one
        
        return dp[0];
    }
}