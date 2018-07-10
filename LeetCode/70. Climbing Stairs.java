class Solution { //Dynamic Programming
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}




/***

Approach 1: Brute Force 
--> O(2^n) Size of recursion tree will be 2^n, i.e. Number of nodes = O(2^n); Space is O(n)

Approach 2: Recursion with Memoization
-->O(n) Size of recursion tree can go upto n, Space is O(n) i.e depth of the recursion tree can go upto n

Approach 3: Dynamic Programming
--> O(n) running and space time

Approach 4: Fibonacci Number
--> O(n) running time and O(1) space time

TODO:

Approach 5: Binets Method
--> O(log(n)) running time and O(1) space time

Approach 5: Fibonacci Formula
--> O(log(n)) running time and O(1) space time

***/


