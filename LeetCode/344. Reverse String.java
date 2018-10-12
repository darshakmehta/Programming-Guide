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

class Solution { //Efficient than above 2 solutions
    public String reverseString(String s) {
        char ch[] = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++; j--;
        }
        
        return new String(ch);
    }
}

/*** Method 1: Converting String into Bytes ***/
/*** Method 2: Using built in reverse() method of the StringBuilder class {Solution 1} ***/ 
/*** Method 3: Converting String to character array {Solution 3} ***/ 
/*** Method 4: Convert the input string into character array by using the toCharArray() and Reverse a String using swapping ***/
/*** Method 5: Using ArrayList object or StringBuffer.append() {Solution 2} ***/

//Reference: geeksforgeeks

