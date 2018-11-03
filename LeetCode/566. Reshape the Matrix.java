class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int a[][] = new int[r][c];
        
        if(r * c != nums.length * nums[0].length) { //check if possible r * c
            return nums;
        } else {
            int temp[] = new int[nums.length * nums[0].length]; //You can use any data structure
            int k = 0;
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < nums[0].length; j++) {
                    temp[k++] = nums[i][j]; //Copy all elements to temp[]
                }
            }
            k = 0;
            for(int m = 0; m < r; m++) {
                        for(int n = 0; n < c; n++) {
                          a[m][n] = temp[k++];  //Store elements in new matrix from temp[]
                        }
            }
            return a;
        }
    }
}

/***

TODO:
1. Without Extra Space of temp[] we can put conditions to update the resultant array at the same time
2. Using Division and Modulus Operation: The idea behind this approach is as follows. Do you know how a 2-D array is stored in the main memory(which is 1-D in nature)? It is internally represented as a 1-D array only. 
Read More: https://leetcode.com/problems/reshape-the-matrix/solution/
3. Also you can reduce to one loop - https://leetcode.com/problems/reshape-the-matrix/discuss/102513/One-loop

**/