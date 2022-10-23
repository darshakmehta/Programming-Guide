/**
 * Using 2-D DP Array.
 * Ideone: https://ideone.com/IGBcCv
 */
class Solution {
    public static boolean isSubsetSum(int[] arr, int n, int sum) { // Time: O(n*sum) and Space: O(n*sum)
        boolean[][] dp = new boolean[n+1][sum+1];

        // Base case - any set can generate sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String args[]) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}

/**
 * Time Improvement: if we found a match on sum column we return true
 * Ideone: https://ideone.com/fMq9Lg
 */
class Solution {
    public static boolean isSubsetSum(int[] arr, int n, int sum) { // Time: O(n*sum) and Space: O(n*sum)
        boolean[][] dp = new boolean[n+1][sum+1];

        // Base case - any set can generate sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                // if we found a subset on sum column return true
                if (j == sum && dp[i][j]) {
                    return true;
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String args[]) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 30;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}

/**
 * Space Improvement: Using O(sum) space
 * Ideone: https://ideone.com/tXLVu5
 */
class Solution {
    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        boolean[] dp = new boolean[sum+1];

        // Base case - any set can generate sum 0
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
                // Once we find a subset we can break out
                if (dp[sum]) {
                    return true;
                }
            }
        }

        return dp[sum];
    }

    public static void main(String args[]) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}
