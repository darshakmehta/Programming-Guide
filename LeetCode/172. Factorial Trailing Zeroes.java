class Solution {
    public int trailingZeroes(int n) {
        if(n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n/5;
            n = n/5;
        }
        return sum;
    }
}