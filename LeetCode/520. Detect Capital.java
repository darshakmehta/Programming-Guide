class Solution {
    public boolean detectCapitalUse(String word) {
        
        boolean result = false;
        
        if(word.toUpperCase().equals(word)) result = true;
        else if(word.toLowerCase().equals(word)) result = true;
        else if( (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') 
               && word.substring(1).toLowerCase().equals(word.substring(1)) ) result = true;

        return result;
    }
}