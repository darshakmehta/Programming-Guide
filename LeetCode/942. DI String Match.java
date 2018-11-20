class Solution {
    public int[] diStringMatch(String S) {
        int countI = 0;
        int countD = 0;
        char[] ch = S.toCharArray();
        for(char c : ch) {
            if(c == 'I') countI++;
        }
        if(countI == 0)
            countD = S.length() - countI;
        else
            countD = S.length();
        
        int result[] = new int[S.length() + 1];
        int k = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == 'I')
                result[i] = k++;
            else
                result[i] = countD--;
        }
        if(ch[ch.length - 1] == 'D') 
            result[ch.length] = k;
        else 
            result[ch.length] = k;
        return result;
    }
}