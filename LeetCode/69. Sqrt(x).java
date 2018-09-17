class Solution { //O(sqrt(n))
    public int mySqrt(int x) {
        int result = 0;
        if(x == 1)
            return 1;
        for(long i = 1; i <= x / 2; i++) { //x/2 since any sqrt cannot be larger than that
           
            if(i * i <= x) {
                result = (int) i;
            }
        }
        return result;
    }
}

class Solution { //O(log(n))  //Binary Search
    public int mySqrt(int x) {
        int result = 0;
        if(x == 0 || x == 1)
            return x;
        int start = 0;
        int end = x/2;
        while(start <= end) {
            long mid = (start + end) / 2;
            if( mid * mid == x)
                return (int) mid; //perfect square
            if(mid * mid < x) {
                start = (int) mid + 1;
                result = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }
        return result;
    }
}

/***

Note: Always check for overflow, above code will get TLE for large numbers.
Better solution is to do Binary Search and move as closer to sqrt(x), instead of looking linearly for every number.

***/