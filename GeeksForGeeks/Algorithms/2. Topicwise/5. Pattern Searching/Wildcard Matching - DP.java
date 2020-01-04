class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s.equals("") && p.equals("")) return true;
        else if(!s.equals("") && p.equals("")) return false;
        
        char[] stringArr = s.toCharArray();
        char[] arr = p.toCharArray();
        
        StringBuilder sb = new StringBuilder(String.valueOf(arr[0]));
        
        /* Transform a**b**c => a*b*c in pattern */
        for ( int i = 1, j = 1; i < p.length(); i++) {
            if (arr[i] == arr[i - 1]) {
                if( arr[i] != '*') {
                    sb.append(arr[i]);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        
        char[] patternArr = sb.toString().toCharArray(); //New Pattern Array
        
        int m = stringArr.length;
        int n = patternArr.length;
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        if(n > 0 && patternArr[0] == '*')
            dp[0][1] = true;

        for ( int i = 1; i < m + 1; i++ ) {
            for ( int j = 1; j < n + 1; j++ ) {
                if( stringArr[i - 1] == patternArr[j - 1] || patternArr[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if( patternArr[j - 1] == '*' ) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } 
            }   
        }
        
        /* Print DP */
        // for ( int i = 0; i < m + 1; i++ ) {
        //     for ( int j = 0; j < n + 1; j++ ) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        
        
        return dp[m][n];
        
    }
}

/* O(n) space solution */




class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s.equals("") && p.equals("")) return true;
        else if(!s.equals("") && p.equals("")) return false;
        else if(s.equals("") && p.equals("*")) return true;
        else if(s.equals("") && p.equals("?")) return false;
        else if(s.equals("")) return false;
        
        char[] stringArr = s.toCharArray();
        char[] arr = p.toCharArray();
        
        StringBuilder sb = new StringBuilder(String.valueOf(arr[0]));
        
        /* Transform a**b**c => a*b*c in pattern */
        for ( int i = 1, j = 1; i < p.length(); i++) {
            if (arr[i] == arr[i - 1]) {
                if( arr[i] != '*') {
                    sb.append(arr[i]);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        
        char[] patternArr = sb.toString().toCharArray(); //New Pattern Array
        
        int m = stringArr.length;
        int n = patternArr.length;
        
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            if (patternArr[i] == '*') {
                for (int j = 0; j < m; j++) {
                    dp[j + 1] = dp[j] || dp[j + 1]; 
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    dp[j+1] = (patternArr[i] == '?' || patternArr[i] == stringArr[j]) && dp[j];
                }
                dp[0] = false;
            }
        }
        return dp[m];
    }
}

/***

TODO:

1. O(n) time and O(n) space
2. O(n * m) time and O(n) space { Improved version of above solution }

**/