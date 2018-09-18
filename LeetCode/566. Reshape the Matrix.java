class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int a[][] = new int[r][c];
        
        if(r * c != nums.length * nums[0].length) {
            return nums;
        } else {
            int temp[] = new int[nums.length * nums[0].length];
            int k = 0;
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < nums[0].length; j++) {
                    temp[k++] = nums[i][j];
                }
            }
            k = 0;
            for(int m = 0; m < r; m++) {
                        for(int n = 0; n < c; n++) {
                          a[m][n] = temp[k++];  
                        }
            }
            return a;
        }
    }
}