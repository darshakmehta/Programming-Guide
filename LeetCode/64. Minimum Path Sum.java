class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
       
        int pathCost[][] = new int[m+1][n+1];

		pathCost[0][0] = grid[0][0];
        
        /* Find path Cost in first column */
		for(int i = 1; i <= m; i++) {
			pathCost[i][0] = grid[i][0] + pathCost[i-1][0];
		}
        /* Find path Cost in first row */
		for(int j = 1; j <= n; j++) {
			pathCost[0][j] = grid[0][j] + pathCost[0][j - 1];
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				pathCost[i][j] = Math.min(pathCost[i][j - 1], 
                                           pathCost[i - 1][j]) + grid[i][j];
			}
		}
        /* Print Path
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(pathCost[i][j] + " ");
            }
            System.out.println();
        }
        */
		return pathCost[m][n];
    }
}

/***

TODO: Without using extra space

***/