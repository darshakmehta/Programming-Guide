class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        
        /* Rowwise */
        for ( int i = 0; i < n; i++ ) {
            int max = Integer.MIN_VALUE;
            for ( int j = 0; j < m; j++ ) {
                if ( grid[i][j] > max ) {
                    max = grid[i][j];
                }
            }
            row[i] = max;
        }
        
        /* Columnwise */
        for ( int i = 0; i < m; i++ ) {
            int max = Integer.MIN_VALUE;
            for ( int j = 0; j < n; j++ ) {
                if ( grid[j][i] > max ) {
                    max = grid[j][i];
                }
            }
            col[i] = max;
        }
        
        int result = 0;
        
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                int x = Math.min ( row[i], col[j] );
                result += Math.abs( grid[i][j] - x );
            }
        }
        
        return result;
        
    }
}

/**

TODO: Traverse 2D matrix both rowwise and columnwise in one nested for loop 

*/