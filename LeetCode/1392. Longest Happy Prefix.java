class Solution { // KMP substring method
    public String longestPrefix(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = dp[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                dp[i] = ++j;
            }
        }
        return s.substring(0, dp[n - 1]);
    }
}
