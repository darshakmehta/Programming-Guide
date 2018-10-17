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