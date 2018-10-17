class Solution {
     public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend > 0 && divisor > 0) {
            return divideHelper(-dividend, -divisor);
        } else if (dividend > 0) {
            return -divideHelper(-dividend, divisor);
        }
        else if(divisor > 0) {
            return -divideHelper(dividend, -divisor);
        }
        else {
            return divideHelper(dividend, divisor);
        }
    }


    private int divideHelper(int dividend, int divisor) {
        int result = 0;
        int currentDivisor = divisor;
        while(true) {
            if(dividend > divisor) {
                break;
            }
            int temp = 1;
            while(dividend <= currentDivisor << 1 && currentDivisor << 1 < 0) {
                temp = temp << 1;
                currentDivisor = currentDivisor << 1;
            }
            dividend -= currentDivisor;
            result += temp;
            currentDivisor = divisor;
        }
        return result;
    }
}

/***

References: leetcode.com/problems/divide-two-integers/discuss/13417/No-Use-of-Long-Java-Solution/13617

***/