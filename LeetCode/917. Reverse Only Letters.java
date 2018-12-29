class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuffer result = new StringBuffer(S);
        
        int low = 0; 
        int high = result.length() - 1;
        char t1, t2;
        while(low < high) {
            char c1 = result.charAt(low);
            
            while(!((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) { // Not a alphabet
                low++;
                if(low < result.length())
                    c1 = result.charAt(low);
                else {
                    return result.toString();
                }
            } 
            
            if(low >= high)
                break;
            
            t1 = result.charAt(low);
            char c2 = result.charAt(high);
            
            while(!((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z'))) { // Not a alphabet
                high--;
                c2 = result.charAt(high);
            }
            
            t2 = result.charAt(high);
            
            result.setCharAt(low, t2);
            result.setCharAt(high, t1);
            low++;
            high--;
              
        }
        return result.toString();
        
    }
}