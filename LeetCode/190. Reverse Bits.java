public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder("");
        
        int count = 0;
        while(n != 0) {
            sb.insert(0,Integer.remainderUnsigned(n,2)+"");
                count++;
            n = Integer.divideUnsigned(n, 2);
        }
        
        for(int i = count; i < 32; i++) {
            sb.insert(0, "0");
        }
        
        sb = sb.reverse();
        long ans = 0;
        
        for(int i = 31; i >= 0; i--) {
        	ans += ((int) (sb.charAt(31 - i) - '0')) * Math.pow(2,i);
        }
        Integer x = (int) (long) ans;
        return x;
    }
}