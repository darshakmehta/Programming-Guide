class Solution {
    public int countPrimes(int n) {
        boolean a[] = new boolean[n];
        for(int i = 2; i < n; i++)
            a[i] = true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(a[i]) {
                for(int j = i * i; j < n ; j+=i) {
                    a[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++)
            if(a[i])
                count++;
        return count;
    }
}