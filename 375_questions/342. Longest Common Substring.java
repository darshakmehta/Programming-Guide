class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }
}

/**
 * Space Improvement - since we only require previous and current row
 * Note: we could improve to O(min(n,m))
 */
class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) { // Time: O(n*m) and Space: O(2*m) i.e. O(m)
        int[][] dp = new int[2][m+1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i%2][j] = dp[(i-1)%2][j-1] + 1;
                    result = Math.max(result, dp[i%2][j]);
                } else {
                    dp[i%2][j] = 0;
                }
            }
        }

        return result;
    }
}

/**
 * Space Improvement => From O(m) to O(min(m,n))
 */
class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        String s1, s2;
        if (n > m) {
            s1 = S2;
            s2 = S1;
        } else {
            s1 = S1;
            s2 = S2;
        }
        n = s1.length();
        m = s2.length();

        int[][] dp = new int[2][m+1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i%2][j] = dp[(i-1)%2][j-1] + 1;
                    result = Math.max(result, dp[i%2][j]);
                } else {
                    dp[i%2][j] = 0;
                }
            }
        }

        return result;
    }
}
