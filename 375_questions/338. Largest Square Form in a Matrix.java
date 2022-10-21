class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int[][] dp = new int[n][m];

        // Base cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0];
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxMatSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxMatSize = Math.max(maxMatSize, dp[i][j]);
            }
        }

        return maxMatSize;
    }
}

/**
 * Minor Improvement - by updating max matrix size
 */
class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int[][] dp = new int[n][m];
        int maxMatSize = 0;

        // Base cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0];
            maxMatSize = Math.max(maxMatSize, dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
            maxMatSize = Math.max(maxMatSize, dp[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    maxMatSize = Math.max(maxMatSize, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxMatSize;
    }
}

/**
 * Space optimization - Since we are relying only on previous and current row we can make a 2*m matrix.
 */
class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int[][] dp = new int[2][m];
        int maxMatSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int entry = mat[i][j];
                if (j != 0 && mat[i][j] == 1) {
                    entry = Math.min(dp[1][j-1], Math.min(dp[0][j-1], dp[1][j])) + 1;
                }

                dp[0][j] = dp[1][j];
                dp[1][j] = entry;
                maxMatSize = Math.max(maxMatSize, entry);
            }
        }

        return maxMatSize;
    }
}
