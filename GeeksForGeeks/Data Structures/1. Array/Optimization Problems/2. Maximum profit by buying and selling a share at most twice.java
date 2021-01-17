/**
 * Using 2D Array Time Complexity: O(no. of days * k) Space Complexity: O(no. of days * k)
 */
class Solution {
    public int maxProfit(int[] price) {
        int n = prices.length;
        int K = 2;
        int[][] T = new int[K + 1][n];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0]; // We invested on day 1 so our profit is negative price at day 1
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }

        return T[K][n - 1];
    }
}

/**
 * To improve space complexity we can use 1D Array
 * Note: Following solution will work for maximum 2 transaction only
 *
 * Steps:
 * 1. Create a profit[n] with initial profit as 0 where n = no. of days
 * 2. Traverse prices[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable
 *    from one transaction in subarray prices[i..n-1]
 * 3. Traverse prices[] from left to right and update profit[i] such that profit[i] stores maximum profit such that
 *    profit[i] contains maximum achievable profit from two transactions in subarray prices[0..i].
 * 4. Finally return profit at profit[n-1].
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2; // no. of transactions

        int[] profit = new int[n];


        int max_price = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > max_price) {
                max_price = prices[i];
            }
            profit[i] = Math.max(profit[i + 1], max_price - prices[i]);
        }

        int min_price = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            profit[i] = Math.max(profit[i - 1], profit[i] + (prices[i] - min_price));
        }

        return profit[n - 1];
    }
}

/**
 * Example: prices[0...n] = {10, 22, 5, 75, 65, 80}
 * 1. Initialize max_price = prices[n - 1] // Maximum price at which we can sell
 *
 * for i = n - 2 ... 0 // Right to Left: profit[i = n - 2 ... 0]
 *     if (current price is greater than max_price, sell at current price)
 *        max_price = prices[i]
 *     profit[i] = Max(Profit of selling next day (no transaction on current day), Profit of buying today)
 *
 * 2. Initialize min_price = prices[0] // Minimum price at which we can buy
 *
 * for i = 1 ... n - 1 // Left to Right: profit[i = 1 ... n - 1]
 *
 *     if (current price is lesser than min_price, buy at current price)
 *        min_price = prices[i]
 *     profit[i] = Max(
 *           Profit of buying previous day (no transaction on current day),
 *           Profit of selling today + Previous Transaction Profit)
 *
 * 3. Finally return profit[n - 1]
 */

// Print Actual Solution















