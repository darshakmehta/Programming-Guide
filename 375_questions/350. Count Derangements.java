/**
 * Using 1-D DP array
 * Ideone: https://ideone.com/j588Ei
 */
class Solution {
    public static int countDer(int n) {
        int[] dp = new int[n+1];
        // base case
        dp[0] = -1;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i-1] + dp[i-2]);
        }

        return dp[n];
    }

    public static void main (String[] args) {
        int n = 4;
        System.out.println("Count of Derangements is " +
                countDer(n));

    }
}

/**
 * Space Improvement - since we depend only on previous two values
 * Ideone: https://ideone.com/lLCVUc
 */
class Solution {
    public static int countDer(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        int[] dp = new int[n+1];
        // base case
        int a = 0;
        int b = 1;

        for (int i = 3; i <= n; i++) {
            int temp = (i - 1) * (a + b);
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main (String[] args) {
        int n = 4;
        System.out.println("Count of Derangements is " +
                countDer(n));

    }
}
