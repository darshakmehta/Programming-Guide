class Solution {
    public int numJewelsInStones(String j, String s) { // Linear Solution: O(J + S)
        
        int count = 0;
        int[] a = new int[255];

        for ( int i = 0; i < j.length(); i++ ) {
            a[j.charAt(i)] += 1;
        }
        
        for ( int i = 0; i < s.length(); i++ ) {
            if ( a[s.charAt(i)] > 0 ) {
                count++;
            }
        }
        
        return count;
    }
}

class Solution { // 100% solution
    public int numJewelsInStones(String j, String s) { // Linear Solution: O(J + S)
        
        boolean[] flag = new boolean[128]; // Depending on JVM implementation takes space, not particularly defined

        for ( char c : j.toCharArray() ) {
            flag[c] = true;
        }
        
        int count = 0;

        for ( char c : s.toCharArray() ) {
            if ( flag[c] ) count++;
        }
        
        return count;
    }
}

/**

Remember: 

boolean: The boolean data type has only two possible values: true and false. Use this data type for simple flags that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that's precisely defined.

Reference: 

1. https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

Important Readings:

1. https://stackoverflow.com/a/605451/4489066

*/