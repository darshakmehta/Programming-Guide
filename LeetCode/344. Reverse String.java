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


/*** Method 1: Converting String into Bytes ***/
/*** Method 2: Using built in reverse() method of the StringBuilder class ***/
/*** Method 3: Converting String to character array ***/
/*** Method 4: Convert the input string into character array by using the toCharArray() and Reverse a String using swapping ***/
/*** Method 5: Using ArrayList object ***/

//Reference: geeksforgeeks

