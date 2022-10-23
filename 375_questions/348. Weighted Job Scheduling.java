/**
 * Using 1-D DP array
 * Ideone: https://ideone.com/XassAF
 */
class Solution { // Time: O(n^2) and Space: O(n)
    static class Job {
        int start, finish, profit;
        Job (int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public static boolean doNotOverlap(Job j1, Job j2) {
        if (j1.finish <= j2.start) {
            return true;
        }
        return false;
    }

    public static int findMaxProfitDP(Job[] arr, int n) {
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i].profit;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (doNotOverlap(arr[j], arr[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i].profit);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }

    public static int findMaxProfit(Job[] arr, int n) {
        // sort based on finish time
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.finish - j2.finish;
            }
        });

        return findMaxProfitDP(arr, n);
    }


    public static void main(String args[]) {
        int n = 4;
        Job arr[] = new Job[n];
        arr[0] = new Job(3, 10, 20);
        arr[1] = new Job(1, 2, 50);
        arr[2] = new Job(6, 19, 100);
        arr[3] = new Job(2, 100, 200);
        System.out.println("The optimal profit is "
                + findMaxProfit(arr, n));
    }
}

/**
 * TODO:
 * 1. Using Binary Search - O(nlogn)
 */
