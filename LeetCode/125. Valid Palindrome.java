class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        s = s.replaceAll("[^A-Za-z0-9]", "");
        return new StringBuffer(s).reverse().toString().equalsIgnoreCase(s);
    }
}