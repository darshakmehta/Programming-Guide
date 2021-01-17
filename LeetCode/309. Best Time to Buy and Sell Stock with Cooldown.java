/**
 *  State Machine Function - 3 possible states
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] S0 = new int[n]; // can rest or stay
        int[] S1 = new int[n]; // can stay or buy
        int[] S2 = new int[n]; // can sell

        S0[0] = 0; // no stock
        S1[0] = -prices[0]; // After buy, profit day 1 stock price
        S2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            S0[i] = Math.max(S0[i - 1], S2[i - 1]); // Stay at S0, or rest from S2
            S1[i] = Math.max(S1[i - 1], S0[i - 1] - prices[i]); // Stay at S1 or buy from S0
            S2[i] = S1[i - 1] + prices[i]; // Only one way from S1
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println("At i = " + i + " S0[i] = " + S0[i] + " S1[i] = " + S1[i] + " S2[i] = " + S2[i]);
//        }

        return Math.max(S0[n - 1], S2[n - 1]);
    }
}

/**
 * Input: [10,22,5,75,65,80]
 *
 * At i = 0 S0[i] = 0 S1[i] = -10 S2[i] = -2147483648
 * At i = 1 S0[i] = 0 S1[i] = -10 S2[i] = 12
 * At i = 2 S0[i] = 12 S1[i] = -5 S2[i] = -5
 * At i = 3 S0[i] = 12 S1[i] = -5 S2[i] = 70
 * At i = 4 S0[i] = 70 S1[i] = -5 S2[i] = 60
 * At i = 5 S0[i] = 70 S1[i] = -5 S2[i] = 75
 */

// TODO: Improve Space complexity to O(1)
// TODO: Print Actual Solution: eg: [Buy, Sell, Cooldown, Buy Sell]
