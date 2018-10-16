class Solution {
    public int getSum(int a, int b) {
        int count = 0;
        while(a!=0) {
            if(a>0){
                count++;
                a--;
            } else {
                count--;
                a++;
            }
        }
        while(b!=0) {
            if(b>0){
                count++;
                b--;
            } else {
                count--;
                b++;
            }
        }
        return count;
    }
}

// Bit Manipulation
class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}