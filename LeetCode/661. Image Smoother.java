class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] sumArr = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 1;
                if((i - 1) >= 0 && (j - 1) >= 0) {
                    sumArr[i][j] += M[i - 1][j - 1];
                    count += 1;
                }
                if((i - 1) >= 0) {
                    sumArr[i][j] += M[i - 1][j];
                    count += 1;
                }
                if((i - 1) >= 0 && (j + 1) < n) {
                    sumArr[i][j] += M[i - 1][j + 1];
                    count += 1;
                }
                if((j - 1) >= 0) {
                    sumArr[i][j] += M[i][j - 1];
                    count += 1;
                }
                if((j + 1) < n) {
                    sumArr[i][j] += M[i][j + 1];
                    count += 1;
                }
                if((i + 1) < m && (j - 1) >= 0) {
                    sumArr[i][j] += M[i + 1][j - 1];
                    count += 1;
                }
                if((i + 1) < m && (j + 1) < n) {
                    sumArr[i][j] += M[i + 1][j + 1];
                    count += 1;
                }
                if((i + 1) < m) {
                    sumArr[i][j] += M[i + 1][j];
                    count += 1;
                }
                sumArr[i][j] += M[i][j];
                //System.out.println(i + " " + j + " " + sumArr[i][j] + " " + count);
                sumArr[i][j] = (int)Math.floor(sumArr[i][j]/count);    
            }
        }
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(sumArr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return sumArr;
    }
}