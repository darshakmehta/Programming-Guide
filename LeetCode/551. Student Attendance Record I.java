class Solution {
    public boolean checkRecord(String s) {
        if (s.indexOf('A') != -1) {
            if (s.indexOf('A', s.indexOf('A') + 1) != -1) {
                return false;
            } 
        }
        
        if (s.indexOf("LLL") != -1)
            return false;
        
        return true;
    }
}