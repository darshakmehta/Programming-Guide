class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuffer sb = new StringBuffer(S);
        int low = 0; 
        int high = sb.length() - 1;
        char t1;
        char t2;
        while(low < high) {
            char c1 = sb.charAt(low);
            while(!((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) {
                low++;
                if(low < sb.length())
                    c1 = sb.charAt(low);
                else {
                    return sb.toString();
                }
            } 
            if(low >= high)
                break;
            
            t1 = sb.charAt(low);
            
            char c2 = sb.charAt(high);
            while(!((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z'))) {
                high--;
                c2 = sb.charAt(high);
            }
            t2 = sb.charAt(high);
            
            sb.setCharAt(low, t2);
            sb.setCharAt(high, t1);
            System.out.println(sb.toString());
            System.out.println(low + "  " + high);
            low++;
            high--;
            
            
        }
        return sb.toString();
        
    }
}