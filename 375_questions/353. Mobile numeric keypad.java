class Solution {
    static int keypad[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1},
    };

    public static long calculate(long[][] dp, int i, int j, int n) {
        // single number return 1;
        if (n == 1) {
            return 1;
        }
        // if already found, return;
        if (dp[keypad[i][j]][n] != -1) {
            return dp[keypad[i][j]][n];
        }
        // calculate up, down, left, right starting at current keypad number
        long a = calculate(dp, i, j, n-1);
        long up = 0, down = 0, left = 0, right = 0;

        // calculate up, down, left, right
        if (j - 1 >= 0 && keypad[i][j-1] != -1) {
            left = calculate(dp, i, j - 1, n - 1);
        }
        if (j + 1 < 3 && keypad[i][j+1] != -1) {
            right = calculate(dp, i, j + 1, n - 1);
        }
        if (i - 1 >= 0 && keypad[i-1][j] != -1) {
            up = calculate(dp, i-1, j, n - 1);
        }
        if (i + 1 < 4 && keypad[i+1][j] != -1) {
            down = calculate(dp, i+1, j, n - 1);
        }

        dp[keypad[i][j]][n] = a + up + down + left + right;
        return dp[keypad[i][j]][n];
    }

    public long getCount(int n) {
        // Base cases
        if (keypad == null || n <= 0) {
            return 0;
        }

        long[][] dp = new long[10][n+1];
        long result = 0;

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] != -1) {
                    result += calculate(dp, i, j, n);
                }
            }
        }

        return result;
    }
}
