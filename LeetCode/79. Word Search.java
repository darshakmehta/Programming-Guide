class Solution {
    
    int y;
    int x;
    char[][] grid;
    
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;
        grid = board;
        y = grid.length;
        if(y == 0) return false;
        x = grid[0].length;
        
        
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(dfs(i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int pos, String word) {
        if(pos == word.length()) return true;
        if(i < 0 || i >= y) return false;
        if(j < 0 || j >= x) return false;
        if(grid[i][j] != word.charAt(pos)) return false;
        
        grid[i][j] ^= 256; //mark visited

        boolean exist = dfs(i, j + 1, pos + 1, word) ||
        dfs(i, j - 1, pos + 1, word) ||
        dfs(i + 1, j, pos + 1, word) ||
        dfs(i - 1, j, pos + 1, word);

        grid[i][j] ^= 256;
        return exist;
    }
}