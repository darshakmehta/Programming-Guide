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
        
        boolean[] prevdp = new boolean[n + 1];
        boolean[] nextdp = null;
        
       
        nextdp = new boolean[n  + 1];
        if(n > 0 && patternArr[0] == '*') {
            nextdp[1] = true;
            prevdp[1] = true;
        }


        for ( int i = 1; i < m + 1; i++ ) {
            
        
            for ( int j = 1; j < n + 1; j++ ) {
                
                if( stringArr[i - 1] == patternArr[j - 1] || patternArr[j - 1] == '?') {
                    nextdp[j] = prevdp[j - 1];
                    nextdp[0] = false;
                } else if( patternArr[j - 1] == '*' ) {
                    nextdp[j] = prevdp[j] || nextdp[j - 1];
                } else {
                    nextdp[j] = false;
                    nextdp[0] = false;
                }
            } 
            
            System.out.println("Previous");
            for(boolean b: prevdp)
                System.out.print(b + " ");
            System.out.println();
            
            System.arraycopy(nextdp, 0, prevdp, 0, n + 1);
            //Try deep copy using cloning like this /* prevdp = nextdp.clone() */
            System.out.println("Next");
            for(boolean b: prevdp)
                System.out.print(b + " ");
            System.out.println();
        }
        
        return nextdp[n];
        
    }
}

/**

TODO:

Learn about shallow copy and deep copy for arrays => https://www.geeksforgeeks.org/arrays-in-java/ 



**/