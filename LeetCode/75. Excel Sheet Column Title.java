/***
Running time: O(N)
***/


class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        
        while(n!=0) {
            if(n%26 == 0) {
                sb.append('Z');
                n = n/26 - 1;
            }else {
                int b =  64+n%26;
                sb.append((char)b);
                n = n/26;
            }
        }
        return sb.reverse().toString();
    }
}