class Solution {
    int y; // length of the grid
    int x; // width of the grid

    public int numIslands(char[][] grid) {
        y = grid.length;
        if (y == 0) return 0;
        x = grid[0].length;

        int count = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= y) return;
        if (j < 0 || j >= x) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '0'; // mark visited

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j + 1, grid);
        dfs(i - 1, j - 1, grid);
        dfs(i + 1, j - 1, grid);
        dfs(i - 1, j + 1, grid);
    }
}
