class Solution {
	public int uniquePaths(int m, int n) {
	    double value = 1;
	    for (int i = 1; i <= n - 1; i++) {
	        value *= ((double) (m + i - 1) / (double) i);
	    }
	    return (int) Math.round(value);
	}
}

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m + 1; i <= m + n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}

class Solution {
	public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1; //Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
	}
}