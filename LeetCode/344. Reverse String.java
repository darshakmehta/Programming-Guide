/***
Running time: O(N) where N = length of string
***/

class Solution {
    public String reverseString(String s) {
    	//Method 2
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse() + "";
    }
}


class Solution {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer("");
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}

class Solution { //Method 4: Efficient than above 2 solutions
    public String reverseString(String s) { // O(n) ==> n/2 times
        char ch[] = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) { //Loop is prune to n/2
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++; j--;
        }
        
        return new String(ch);
    }
}

class Solution { // Inefficient as compare to above efficient solution, as we loop entire string
    public String reverseString(String s) {
        
        char[] result = new char[s.length()];
        
        for( int i = result.length - 1, k = 0; i >= 0 ; i--, k++) {
            result[i] = s.charAt(k);
        }
        
        return String.valueOf(result);
     }
}

/*** TODO: Method 1: Converting String into Bytes ***/
/*** Method 2: Using built in reverse() method of the StringBuilder class {Solution 1} ***/ 
/*** Method 3: Converting String to character array  ***/ 
/*** Method 4: Convert the input string into character array by using the toCharArray() and Reverse a String using swapping {Solution 3} ***/
/*** Method 5: Using ArrayList object or StringBuffer.append() {Solution 2} ***/

//Reference: geeksforgeeks