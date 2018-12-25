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

class Solution {
    public boolean judgeCircle(String moves) {
        
        int countU = 0, countR = 0, countD = 0, countL = 0;
        
        for(char c : moves.toCharArray()) {
            if(c == 'U') countU++;
            else if(c == 'R') countR++;
            else if(c == 'D') countD++;
            else if(c == 'L') countL++;
        }
        
        if( countU == countD && countR == countL ) // Easy to understand
            return true;
        return false;
        
    }
}

/**

Running time: O(N) where N = length of moves

*/