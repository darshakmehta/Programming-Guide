class Solution {
    public int lengthOfLastWord(String s) {
        
        if(s.equals("")) return 0;
        if(s.trim().equals("")) return 0;
        
        String[] arr = s.split(" "); // TODO: Avoid extra space
        return arr[arr.length - 1].length();
        
    }
}

/**

TODO:

1. Speed it up by
	a. Checking if string does not have space by s.trim().indexOf(" ") == -1 //Not much of help
	b. Save space by traversing from last char until space and count the length

**/