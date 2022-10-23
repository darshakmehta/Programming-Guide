class Solution {
    long countPS(String s) {
        int len = s.length();
        int mod = 1000000007;

        int[][] dp = new int[len][len];


        // to traverse diagonally
        for (int diff = 0; diff < len; diff++) {
            for (int i = 0, j = i + diff; j < len; i++, j++) {
                // single character - palindrome
                if (i == j) {
                    dp[i][j] = 1;
                }
                // if both characters are same - palindrome
                else if (diff == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                }
                // if diff > 1 - check outside characters match and if innner string is palindrome
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = (dp[i][j-1] + dp[i+1][j] + 1) % mod;
                    } else {
                        dp[i][j] = ((dp[i][j-1]+dp[i+1][j]) - dp[i+1][j-1]) % mod;
                    }
                    // To avoid the negative results we add mod value
                    if (dp[i][j] < 0) {
                        dp[i][j] += mod;
                    }
                }
            }
        }
        return (dp[0][len-1]) % mod;
    }
}
