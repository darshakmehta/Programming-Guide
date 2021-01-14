class Solution {
    public int maxProfit(int[] prices) {
        int max_profit_so_far = 0;

        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                max_profit_so_far = Math.max(max_profit_so_far, prices[i] - buy);
            }
        }
        return max_profit_so_far;
    }
}
