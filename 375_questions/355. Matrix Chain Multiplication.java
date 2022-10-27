/**
 * Incorrect solution, needs some work.
 * Ideone: https://ideone.com/Fqhtgo
 */
class Solution {
    public static void print2DArr(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int matrixChainOrder(int[] arr, int n) {
        int[][] dp = new int[n][n];

        for (int diff = 2; diff < n; diff++) {
            for (int i = 1; i < n - diff + 1; i++) {
                int j = i + diff - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1] + arr[k] + arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        print2DArr(dp);
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int size = arr.length;

        System.out.println(
                "Minimum number of multiplications is "
                        + matrixChainOrder(arr, size));
    }
}
