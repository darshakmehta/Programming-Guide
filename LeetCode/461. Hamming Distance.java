class Solution {
    
    public String decimalToBinary(int x) {
        StringBuffer sb = new StringBuffer("");
        while(x != 0) {
            sb.append(x % 2);
            x = x/2;
        }
        return sb.reverse().toString();
    }
    
    public int hammingDistance(int x, int y) {
        //System.out.println(decimalToBinary(x));
        //System.out.println(decimalToBinary(y));
        
        StringBuilder sb1 = new StringBuilder(decimalToBinary(x));        
        StringBuilder sb2 = new StringBuilder(decimalToBinary(y));

        int l1 = sb1.length(); //1
        int l2 = sb2.length(); //3
        
        if(l1 > l2) {
            for(int i = (l1 - l2); i > 0; i--) {
                sb2.insert(0, "0");
            }
        } else {
            for(int i = (l2 - l1); i > 0; i--) {
                sb1.insert(0, "0");
            }
        }
        
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        int count = 0;
        for(int i = 0; i < sb1.length(); i++) {
            if(sb1.charAt(i) != sb2.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}

/** Update **/

class Solution {
    
    public int hammingDistance(int x, int y) {
        
        StringBuilder sb1 = new StringBuilder(Integer.toBinaryString(x));        
        StringBuilder sb2 = new StringBuilder(Integer.toBinaryString(y));

        int l1 = sb1.length(), l2 = sb2.length();
        
        if(l1 > l2)
            for(int i = (l1 - l2); i > 0; i--) sb2.insert(0, "0");
        else
            for(int i = (l2 - l1); i > 0; i--) sb1.insert(0, "0");

        int count = 0;
        for(int i = 0; i < sb1.length(); i++)
            if(sb1.charAt(i) != sb2.charAt(i)) count++;
        
        return count;
    }
}

/***

Note: What does come to your mind first when you see this sentence "corresponding bits are different"? Yes, XOR! Also, do not forget there is a decent function Java provided: Integer.bitCount()

    public class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

TODO: Better Solution using XOR

***/