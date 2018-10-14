class Solution {
    public int maxProfit(int[] prices) {
       
        int profit = 0;
        if(prices.length == 0) 
            return 0;
        int price = prices[0];
        for(int i = 1; i < prices.length; i++) {   
            if(prices[i] > price) {
                profit += prices[i] - price;
            }
            price = prices[i];
        }
        return profit;
    }
}

class Solution { //inefficient
    public int maxProfit(int[] prices) {
        int result = 0;
        int x = 0;
        for(int i = 1; i < prices.length; i++) {
            x = prices[i] - prices[i - 1];
            if(x > 0)
                result += x;
        }
        return result;
    }
}

class Solution { //efficient
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) 
                min = prices[i];
            else if(prices[i] - min > maxProfit)
                maxProfit = prices[i] - min;
        }
        return maxProfit;
    }
}
