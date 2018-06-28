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