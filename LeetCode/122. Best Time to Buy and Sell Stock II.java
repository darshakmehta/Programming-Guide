class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int profit = 0;
        int price = prices[0];

        for (int i = 1; i < n; i++) {
            if (prices[i] > price) {
                profit += prices[i] - price;
            }
            price = prices[i];
        }
        return profit;
    }
}

class Solution { // Very Good Solution
    public int maxProfit(int[] prices) {
        int result = 0;
        int x = 0;
        for (int i = 1; i < prices.length; i++) {
            x = prices[i] - prices[i - 1];
            if (x > 0)
                result += x;
        }
        return result;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int current_profit = 0;

        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy && prices[i] > prices[i - 1]) {
                current_profit = Math.max(current_profit, prices[i] - buy);
            } else {
                buy = prices[i];
                max_profit += current_profit;
                current_profit = 0;
            }
        }

        return max_profit + current_profit;
    }
}

class Solution { // // Much cleaner solution than above
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buy = prices[0];
        int profit = 0;
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] > prices[i]) {
                buy = prices[i];
                result += profit;
                profit = 0;
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }

        return result + profit;
    }
}
