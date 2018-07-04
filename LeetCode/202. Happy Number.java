class Solution {
    
    public int squareDigitsOfNumber(int n) {
        int temp = 0;
        while(n > 0) {
            temp += (n % 10) * (n % 10);
            n = n / 10;
        }
        return temp;
    }
    
    public boolean isHappy(int n) {
        int slow = squareDigitsOfNumber(n);
        int fast = squareDigitsOfNumber(squareDigitsOfNumber(n));
        
        while(slow != 1 && slow != fast) {
            slow = squareDigitsOfNumber(slow);
            fast = squareDigitsOfNumber(fast);
            fast = squareDigitsOfNumber(fast);
        }
        
        return slow == 1;
    }
}