//Write your code here
class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        if(n == 1)
            return 1;
        
        int sum = 1 + n;
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0)
                sum += i;
        }
        return sum;
    }
}

/***

Very important
All the methods of interface should have public visibility [ "public" int divisor_sum ]

***/