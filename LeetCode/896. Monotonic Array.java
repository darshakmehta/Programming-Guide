class Solution {
    public boolean isMonotonic(int[] A) {
        boolean flag = true;
        
        for(int i = 0; i < A.length - 1; i++) {
            if(!(A[i] <= A[i+1])) { //check ascending order
                flag = false;
                break;
            }
        }
        
        if(!flag) {
            for(int i = 0; i < A.length - 1; i++) {
                if(!(A[i] >= A[i+1])) { //check descending order
                    return false;
                }
            }
        }
        
        return true;
    }
}