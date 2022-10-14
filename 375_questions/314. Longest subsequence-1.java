/**
 * Solution 1: Follows GFG solution from here https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/
 * Note: The given solution on GFG site is incorrect.
 */
class Solution {
    static int longestSubsequence(int N, int arr[]) {
        if (N == 1) {
            return 1;
        }

        int[] dp = new int[N];
        // Map stores the maximum length of the subsequence
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        // Base cases
        dp[0] = 1; // Length of only one element of the subsequence
        hmap.put(arr[0], dp[0]);

        for (int i = 1; i < N; i++) {
            if (Math.abs(arr[i] - arr[i-1]) == 1) {
                dp[i] = 1 + Math.max(dp[i - 1], Math.max(hmap.getOrDefault(arr[i] + 1, 0), hmap.getOrDefault(arr[i] -1, 0)));
            } else {
                if (hmap.containsKey(arr[i] + 1) || hmap.containsKey(arr[i] - 1)) {
                    dp[i] = 1 + Math.max(hmap.getOrDefault(arr[i] + 1, 0), hmap.getOrDefault(arr[i] -1, 0));
                } else {
                    dp[i] = 1; // length of single element subsequence
                }
            }
            hmap.put(arr[i], dp[i]);
        }

        // find length of the longest subsequence
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
/**
 * Solution 2: Improved solution without dp[]
 */
class Solution {
    static int longestSubsequence(int N, int arr[]) {
        int result = 1; // Length of only one element of the subsequence

        // Map stores the maximum length of the subsequence
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        hmap.put(arr[0], result);

        for (int i = 1; i < N; i++) {
            int temp = 1; // length of the single element subsequence

            if (
                    (Math.abs(arr[i] - arr[i-1]) == 1) ||
                    (hmap.containsKey(arr[i] + 1) || hmap.containsKey(arr[i] - 1))
            ) {
                temp = 1 + Math.max(hmap.getOrDefault(arr[i] + 1, 0), hmap.getOrDefault(arr[i] - 1, 0));
            }

            result = Math.max(result, temp);
            hmap.put(arr[i], temp);
        }

        return result;
    }
}

