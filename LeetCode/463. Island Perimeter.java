class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        int island = 0;
        int neighbours = 0;
        
        for( int i = 0; i < m; i++ ) {
            for( int j = 0; j < n; j++ ) {
                if( grid[i][j] == 1 ) {
                    island++;
                    
                    if(i < m - 1 && grid[i + 1][j] == 1) neighbours++;
                    if(j < n - 1 && grid[i][j + 1] == 1) neighbours++;
                    
                }
            }
        }
        perimeter = island * 4 - neighbours * 2;
        return perimeter;
    }
}

/**

+--+     +--+                   +--+--+
|  |  +  |  |          ->       |     |
+--+     +--+                   +--+--+

4 + 4 - ? = 6  -> ? = 2

**/