/**
 * Solution similar to Longest Common Subsequence with the help of 2D array
 */
class Solution {
    public int LongestRepeatingSubsequence(String str) {
        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];
        char[] c = str.toCharArray();

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (c[i-1] == c[j-1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }

        return dp[len][len];
    }
}

/**
 * We can improve the above solution by storing prev in a temp variable and utlizing single dimensional array
 */
class Solution {
    public int LongestRepeatingSubsequence(String str) {
        int len = str.length();
        int[] dp = new int[len + 1];
        char[] c = str.toCharArray();

        for (int i = 1; i <= len; i++) {
            int prev = dp[0]; // stores diagonal value
            for (int j = 1; j <= len; j++) {
                int temp = dp[j]; // stores prev. row current index value
                if (c[i-1] == c[j-1] && i != j) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j-1], temp);
                }
                prev = temp; // updates diagonal value
            }
        }

        return dp[len];
    }
}
