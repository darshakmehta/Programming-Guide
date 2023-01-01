/**
 * Using 1-D dp => Time: O(nlogn) and Space: O(n)
 * Ideone: https://ideone.com/83KdUY
 */
class Solution {
    public static int removal(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // base case
        dp[0] = 0; // i.e. n-1 elements to be removed
        int ans = n - 1;

        for (int i = 1; i < n; i++) {
            dp[i] = i;
            int j = dp[i-1];

            while (j <= i && arr[i] - arr[j] > k) {
                j++;
            }
            dp[i] = Math.min(dp[i], j);
            ans = Math.min(ans, (n - (i - j + 1)));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
        int n = arr.length;
        int k = 4;
        System.out.print(removal(arr, n, k));
    }
}

/**
 * Spaced Optimized for above 1-D dp solution => Time: O(nlogn) and Space: O(1)
 * Ideone: https://ideone.com/S0Ivle
 */
class Solution {
    public static int removal(int[] arr, int n, int k) {
        Arrays.sort(arr);
        // store the max length of the array with difference <= k
        int max = Integer.MIN_VALUE;
        int i = 0;

        for (int j = i + 1; j < n && i < n; j++) {
            // if the subarray from i to j index is valid
            // the store it's length
            if (a[j] - a[i] <= k) {
                max = Math.max(max, j - i + 1);
            } else {
                i++;
            }
        }
        // no. of elements need to be removed is going to be
        // (length of array - max) subarray with diff <= k
        int removed = n - max;
        return removed;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
        int n = arr.length;
        int k = 4;
        System.out.print(removal(arr, n, k));
    }
}

/**
 * Using Sliding Window Technique => Time: O(nlogn) and Space: O(1)
 * Ideone: https://ideone.com/3lFQQG
 */
class Solution {
    public static int removal(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int diff = 0;
        int result = 0;

        for (int i = 0, j = 0; i < n; i++) {
            diff = arr[i] - arr[j];

            while (i >= j && diff > k) {
                diff = arr[i] - arr[++j];
            }
            result = Math.max(ans, i - j + 1);
        }

        return n - result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
        int n = arr.length;
        int k = 4;
        System.out.print(removal(arr, n, k));
    }
}
