class Solution {
    public boolean isPalindrome(String s) {
        s= s.replaceAll("[^A-Za-z0-9]","");
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbRev = sb.reverse();
        
        if(s.equalsIgnoreCase(sbRev.toString()))
            return true;
        return false;
    }
}