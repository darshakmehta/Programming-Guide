class MyCalculator extends Exception{
    /*
    * Create the method long power(int, int) here.
    */
    
    public long power(int n, int p) throws Exception{
        long answer = 0;
            if(n < 0 || p < 0)
                throw new Exception("n or p should not be negative.");
            else if(n == 0 && p == 0)
                throw new Exception("n and p should not be zero.");
            else {
                answer = (int) Math.pow(n, p);
            }
        
        return answer;
    }
    
}