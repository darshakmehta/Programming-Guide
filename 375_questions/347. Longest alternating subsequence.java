/**
 * Time Limit exceeds - we can improve it by using 2 variables as we only care about last len of alternating subsequence
 * Passes 100/110 test cases - https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1
 */
class Solution {
    public int AlternatingaMaxLength(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        int result = 1; // since n >= 1

        // every element is a subsequence of length one
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i][1] < dp[j][0] + 1) {
                    dp[i][1] = dp[j][0] + 1;
                }

                if (arr[j] < arr[i] && dp[i][0] < dp[j][1] + 1) {
                    dp[i][0] = dp[j][1] + 1;
                }

                result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
            }
        }

        return result;
    }
}

/**
 * Space improvement
 */
class Solution {
    public int AlternatingaMaxLength(int[] arr) { // Time: O(n) and Space: O(1)
        int n = arr.length;
        int inc = 1;
        int dec = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                inc = dec + 1;
            } else if (arr[i] < arr[i-1]) {
                dec = inc + 1;
            }
        }

        return Math.max(inc, dec);
    }
}
