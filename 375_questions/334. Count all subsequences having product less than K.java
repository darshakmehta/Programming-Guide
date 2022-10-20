class Solution {
    public static int prodSubsequenceCount(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[k+1][n+1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];

                if (arr[j-1] <= i && arr[j-1] > 0) {
                    dp[i][j] += dp[i/arr[j-1]][j-1] + 1;
                }
            }
        }

        return dp[k][n];
    }

    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4};
        int k = 10;
        System.out.println(prodSubsequenceCount(arr, k));
    }
}

// Ideone: https://ideone.com/9jARY5
