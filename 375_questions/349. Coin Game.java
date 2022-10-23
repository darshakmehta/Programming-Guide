/**
 * Theory:
 * Let us take few example values of n for x = 3, y = 4.
 * n = 0 A can not pick any coin so he losses
 * n = 1 A can pick 1 coin and win the game
 * n = 2 A can pick only 1 coin. Now B will pick 1 coin and win the game
 * n = 3 4 A will win the game by picking 3 or 4 coins
 * n = 5, 6 A will choose 3 or 4 coins. Now B will have to choose from 2 coins so A will win.
 * We can observe that A wins game for n coins only when B loses for coins n-1 or n-x or n-y.
 *
 * Ideone: https://ideone.com/70a1ag
 */
class Solution {
    public static boolean findWinner(int x, int y, int n) {
        boolean[] dp = new boolean[n];

        // base case
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i < n; i++) {
            if (i - 1 >= 0 && dp[i-1] == false) {
                dp[i] = true;
            } else if (i - x >= 0 && dp[i-x] == false) {
                dp[i] = true;
            } else if (i - y >= 0 && dp[i-y] == false) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int x = 3, y = 4, n = 5;
        if (findWinner(x, y, n))
            System.out.println('A');
        else
            System.out.println('B');
    }
}
