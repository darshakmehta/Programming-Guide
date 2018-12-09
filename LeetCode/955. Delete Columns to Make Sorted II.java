class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        boolean flag = true;
        for(int c = 0; c < A[0].length(); c++) {
            for(int r = 0; r < A.length - 1; r++) {
                if(A[r].charAt(c) >= A[r + 1].charAt(c)) {
                    result++;
                    flag = false;
                    break;
                } 
            }
            if(flag) 
                return result;
        }
        return result;
    }
}

/*  

Test case: ["xga","xfb","yfa"]

The concern is when I know i have to delete charAt(1); I delete it, later i check a,b,a and it result++, but logically I dont have to check it, since deleting charAt(1) will sort my solution, so I dont have to check and my result will be 1.

Now if I consider deleting charAt(i) when they were result++; I will end up loosing charAt(0) in this case.

Therefore, I have to think of storing results and comparing at every stage if it can form result.


 */