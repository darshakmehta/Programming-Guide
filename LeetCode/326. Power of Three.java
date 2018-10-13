class Solution {
    public boolean isPowerOfThree(int n) {
        
        while(n > 3) {
            if(n % 3 != 0)
                return false;
            n = n / 3;
        }
        if(n == 1 || n == 3) //3^0 and 3^1
            return true;
            
        return false;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        // String baseChange = Integer.toString(n, 3);
        // boolean powerOfThree = baseChange.matches("^10*$")
        // return powerOfThree;

        // In one line
        return Integer.toString(n, 3).matches("^10*$");
    }
}

class Solution { //Fastest
    public boolean isPowerOfThree(int n) {
        
        return n > 0 && 1162261467 % n == 0;
    }
}