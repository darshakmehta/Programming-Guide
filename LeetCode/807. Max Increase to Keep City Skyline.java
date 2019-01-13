class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        
        
        for ( int i = 0; i < grid.length; i++ ) {
            int max = Integer.MIN_VALUE;
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] > max ) {
                    max = grid[i][j];
                }
            }
            row[i] = max;
        }
        
        for ( int i = 0; i < grid[0].length; i++ ) {
            int max = Integer.MIN_VALUE;
            for ( int j = 0; j < grid.length; j++ ) {
                if ( grid[j][i] > max ) {
                    max = grid[j][i];
                }
            }
            col[i] = max;
        }
        
        int result = 0;
        
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                int x = Math.min ( row[i], col[j] );
                result += Math.abs( grid[i][j] - x );
            }
        }
        
        return result;
        
    }
}