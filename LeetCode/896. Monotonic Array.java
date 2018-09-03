class Solution {
    public boolean isMonotonic(int[] A) {
        boolean result = true;
        for(int i = 0; i < A.length - 1; i++) {
            if(!(A[i] <= A[i+1])) {
                result = false;
                break;
            }
        }
        
        if(!result) {
            //System.out.println("Here");
            for(int i = 0; i < A.length - 1; i++) {
                if(!(A[i] >= A[i+1])) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        
        return result;
    }
}