class Solution {
    public int countPrimes(int n) {
        boolean flag[] = new boolean[n];
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!flag[i]) {
                for(int j = i * i; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!flag[i])
                count++;
        }
        return count;
    }
}