/***
Running time: O(N) where N = length of moves
***/

class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0;
        int j = 0;
        for(int k = 0; k< moves.length(); k++) {
            if(moves.charAt(k) == 'R') j++;
            else if(moves.charAt(k) == 'L') j--;
            else if(moves.charAt(k) == 'U') i--;
            else if(moves.charAt(k) == 'D') i++;
        }
        
        if(i ==0 && j ==0) 
            return true;
        
        return false;
    }
}