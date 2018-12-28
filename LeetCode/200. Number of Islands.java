class Solution {
    int y; //length of the grid
    int x; //width of the grid
    char[][] g; //To avoid passing in the stack and saving memory
    
    public int numIslands(char[][] grid) {
        y = grid.length; 
        if(y == 0) return 0;
        x = grid[0].length; 
        
        g = grid;
        int count = 0;
        
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(g[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j) {
        if(i < 0 || i >= y) return;
        if(j < 0 || j >= x) return;
        if(g[i][j] != '1') return;
        
        g[i][j] = '0'; //mark visited
        
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
        
    }
}

/*

Article:

The above solution is looping through the grid, and when it finds the first '1' (land) it marks it as visited and also looks for all the adjacent (horizontally and vertically) (Remember: Question does not ask us to consider the diagonals). Now when it is visiting all its adjacent if it is land, it marks them as water, because those are the connected islands, so all the one's (land) connected will be mark as visited, remember because of recursion it will continue marking as visited to all the connected one's (land).

Consider example:

    11110
    11010
    11000
    00000

Now, while looping we encounter grid[0][0] = 1
therefore, DFS will be called, and count is incremented since we found first land,

Now we will recursively called DFS, until we have grid[i][j] == 1

This way, it will be

    00000
    00000
    00000
    00000

Therefore, count = 1, in the end.

Hope this is helpful

*/