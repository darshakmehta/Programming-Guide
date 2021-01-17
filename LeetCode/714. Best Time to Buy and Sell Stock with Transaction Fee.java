class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int investment_so_far = -prices[0]; // initial buy - stock at day[0]
        int profit_so_far = 0; // initial profit is 0

        // Either you will buy or sell at day[i]
        for (int i = 1; i < n; i++) {

            int prev_investment = investment_so_far; // use to compare profit

            // either you will perform no transaction or buy on day[i]
            // if you do not buy, your current investment stays same
            // or if you buy, profit_so_far is subtracted with buying_price at day[i]
            // i.e investment = Max(no_transaction, profit_so_far - buying_price)
            investment_so_far = Math.max(investment_so_far, profit_so_far - prices[i]);

            // either you will perform no transaction or sell on day[i]
            // if you do not sell, your profit_so_far stays same
            // or if you sell, current selling_price at day[i] is added to prev_investment and
            // subtracted with some transaction_fee
            // i.e. profit = Max(no_transaction, investment_so_far + selling_price - transaction_fee)
            profit_so_far = Math.max(profit_so_far, prev_investment + prices[i] - fee);
        }

        return profit_so_far;
    }
}

// Note: Buy and Sell on same day is no-operation
// Note: When we buy something we loose our profit and when we sell something we gain on our investment
