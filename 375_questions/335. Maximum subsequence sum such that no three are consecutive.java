class Solution {
    public static int maxSubsequenceSumNoThreeConsecutive(int[] arr, int n) {
        int[] dp = new int[n];

        // base case
        if (n >= 1) {
            dp[0] = arr[0];
        }

        if (n >= 2) {
            dp[1] = arr[0] + arr[1];
        }

        if (n > 2) {
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]));
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int arr[] = { 100, 1000, 100, 1000, 1 };
        int n = arr.length;
        System.out.println(maxSubsequenceSumNoThreeConsecutive(arr, n));
    }
}

// Ideone: https://ideone.com/AlVmbE

/**
 * Testcases:
 * Input: arr[] = {1, 2, 3}
 * Output: 5
 * We can't take three of them, so answer is
 * 2 + 3 = 5
 *
 * Input: arr[] = {3000, 2000, 1000, 3, 10}
 * Output: 5013
 * 3000 + 2000 + 3 + 10 = 5013
 *
 * Input: arr[] = {100, 1000, 100, 1000, 1}
 * Output: 2101
 * 100 + 1000 + 1000 + 1 = 2101
 *
 * Input: arr[] = {1, 1, 1, 1, 1}
 * Output: 4
 *
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
 * Output: 27
 */
