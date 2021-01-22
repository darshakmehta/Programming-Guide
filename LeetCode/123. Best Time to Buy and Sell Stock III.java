/* Correct Solution using Dynamic Programming */

// DP Approach 1
/**
 * Steps:
 * 1. Initialize T[k][i] where k = no. of transactions, i = no. of days
 * 2. Since we can make a profit with only 1 day of data even with K number of transactions.
 *    We initialize T[i][0] and T[0][j] = 0
 * 3. For m = 0 ... j - 1 where m = all previous days
 *    T[i][j] = Max(T[i][j-1], prices[j] - prices[m] + T[i - 1][m])
 *    i.e. Max(No transactions, price at current day - price on mth day + profit of one less transaction and finishing on mth day)
 *    for eg: T[2][2] = Max(T[2][1], prices[2] - prices[0] + T[1][0], prices[2] - prices[1] + T[1][1])
 *    Here, if we have max value as prices[2] - prices[1] + T[1][1] => which means we buy on day 1 and sell it on day 2
 *    and again buy on day 2 and sell on day 3. Therefore, choosing previous transaction profit by finishing it on mth day.
 * 4. Finally T[k][n-1] will be the maximum profit
 */

class Solution { // Slower Solution: O(no. of days ^ 2 * K) (K = max transactions allowed)
    public int maxProfit(int[] prices, int K) {
        int n = prices.length;
        int[][] T = new int[K + 1][n];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]); // Find max profit for m = 0 ... j - 1 days
                }
                T[i][j] = Math.max(T[i][j - 1], maxVal);
            }
        }

        return T[K][n - 1];
    }
}

// DP Appraoch 2

/**
 * Steps:
 * 1. Initialize T[k][i] where k = no. of transactions, i = no. of days
 * 2. Since we can make a profit with only 1 day of data even with K number of transactions.
 *    We initialize T[i][0] and T[0][j] = 0
 * 3. Find overlapping subproblem.
 *
 * For j = 3, i = 2
 * m = 0  T[1][0] - prices[0] + prices[3]
 * m = 1  T[1][1] - prices[1] + prices[3]
 * m = 2  T[1][2] - prices[2] + prices[3]
 *
 * For j = 4, i = 2
 *
 * m = 0  T[1][0] - prices[0] + prices[4]
 * m = 1  T[1][1] - prices[1] + prices[4]
 * m = 2  T[1][2] - prices[2] + prices[4]
 * m = 3  T[1][3] - prices[3] + prices[4]
 *
 * Here we can see that maximum of m = 0 ... j - 1 has a constant factor of prices[j]
 * and Maximum of T[i-1][m] - prices[m] for m = 0 ... j - 2)
 * and T[i-1][m] - prices[m] for m = j - 1 (new term for increasing value of j)
 *
 * Therefore, we merge the following factors to avoid calculating m = 0 ... j - 2 each time
 * and rely on previous subproblem i.e. previous maxDiff of T[i-1][m] - prices[m] for m = 0 ... j - 2
 *
 * Updated formulae would look like:
 *
 * Initialize maxDiff = -prices[0] (since we invested on day 1 our profit is negative price of day 1
 *
 * T[i][j] = Max(T[i][j-1], prices[j] + maxDiff)
 * i.e Max(No transactions, current price + maxDiff for m = 0 ... j - 2)
 *
 * where maxDiff = Max(maxDiff, T[i-1][j] - prices[j])
 * i.e Max(maxDiff for m = 0 ... j - 2, previous transaction profit - current price)
 *
 * 4. Finally T[k][n-1] will be the maximum profit
 */

class Solution { // Faster Solution: O(no. of days * K) (K = max transactions allowed)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int K = 2;
        int[][] T = new int[K + 1][n];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0]; // We invested on day 1 so our profit is negative price at day 1
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        printActualSolution(T, prices);
        return T[K][n - 1];
    }
}

/* Print actual solution */

/**
 * Steps:
 * 1. initialize i = no. of transactions and j = no. of days; create Stack
 * 2. while loop with breaking condition => if i == 0 || j == 0 break the loop
 *      3. if T[i][j] == T[i][j-1] continue left j = j - 1;
 *      4. else sell at T[j] price and initialize maxDiff at current profit (T[i][j]) - price at jth day
 *      5. loop k = j - 1 ... 0
 *                if (T[i-1][k] - prices[k] == maxDiff) // check previous transaction to match remainder profit "maxDiff"
 *                  i = i - 1; // go to previous transaction
 *                  j = k; // initialize with current kth day as buying at jth day
 *                  stack.addFirst(j); // buying at jth day
 * 6. Print the actual solution:
 *        buying at stack.pollFirst()
 *        selling at stack.pollFist()
 */

public void printActualSolution(int[][] T, int prices[]) {
    int i = T.length - 1;
    int j = T[0].length - 1;

    Deque<Integer> stack = new LinkedList<>();
    while (true) {
        if (i == 0 || j == 0) {
            break;
        }
        if (T[i][j] == T[i][j-1]) {
            j = j - 1;
        } else { // Transaction (Selling) is completing at ith transaction and jth day.
            stack.addFirst(j); // Selling at jth day
            int maxDiff = T[i][j] - prices[j]; // maxDiff = remaining profit to look in previous transaction
            for (int k = j - 1; k >= 0; k--) { // Find buying day
                if (T[i-1][k] - prices[k] == maxDiff) { // check previous transaction to match remainder profit
                    i = i - 1; // go to previous transaction
                    j = k; // current kth day we found our buying (jth) day
                    stack.addFirst(j); // buying at jth day
                    break;
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }
    }
}

// Solution: https://ideone.com/pZPrME
// Reference: https://www.youtube.com/watch?v=oDhu5uGq_ic





/*** DANGER: Incorrect Solution Ahead ***/

/* Approach 1: Valley-Peak Approach Fails */
// Solution to find infinite number of transactions
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

/*
Above solution fails to choose best 2 transactions (K = 2)

Failed Test Scenario:

[3,3,5,0,0,3,1,4]
*/


/* Approach 2: Valley-peak approach can be used to improve above solution with priority heap to maintain max two values of
transaction.

Failed Test Scenario:

[1,2,4,2,5,7,2,4,9,0]
 */

class Solution {
    // Valley-peak approach fails to consider correct valley. Since it does consider futures days profit.
    // Therefore we choose Dynamic Programming
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int current_profit = 0;

        int buy = prices[0];

        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>();

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy && prices[i] > prices[i - 1]) {
                current_profit = Math.max(current_profit, prices[i] - buy);
            } else {
                buy = prices[i];
//                System.out.println("buy at: " + buy + " day " + (i + 1));
                if (current_profit != 0) {
//                    System.out.println("current_profit : " + current_profit);
//                    System.out.println("size: " + max_heap.size() + " " + max_heap);
                    if (max_heap.size() < 2) {
                        max_heap.add(current_profit);
//                        System.out.println(max_heap);
                    } else {

                        if (current_profit > max_heap.peek()) {
                            max_heap.poll();
                            max_heap.add(current_profit);
                        }
                        max_heap.add(Math.max(current_profit, max_heap.peek()));
                    }
                    current_profit = 0;
                }
            }
        }

        if (current_profit != 0) {
            if (max_heap.size() < 2) {
                max_heap.add(current_profit);
            } else {
                if (current_profit > max_heap.peek()) {
                    max_heap.poll();
                    max_heap.add(current_profit);
                }
            }
        }

//        System.out.println(max_heap);

        while (!max_heap.isEmpty()) {
            max_profit += max_heap.poll();
        }

        return max_profit;
    }
}


