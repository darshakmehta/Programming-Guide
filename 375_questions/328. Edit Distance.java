class Solution {
    public int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j; // Min. operations = j
                }
                // If second string is empty, only option is
                // to remove all characters of second string
                else if (j == 0) {
                    dp[i][j] = i; // Min. operations = i
                }
                else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                            Math.min(dp[i - 1][j], // remove
                                    dp[i][j - 1])); // insert
                }
            }
        }

        return dp[m][n];
    }
}
