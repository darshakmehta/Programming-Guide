class Solution {
    int y; // row
    int x; // col
    char[][] grid;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false; // empty word
        grid = board;
        y = grid.length; // row length
        if (y == 0) return false; // no characters on board
        x = grid[0].length; // column length

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (dfs(i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false; // no word found
    }

    public boolean dfs(int i, int j, int pos, String word) {
        if (pos == word.length()) return true; // found word
        if (i < 0 || i >= y) return false; // out of bound
        if(j < 0 || j >= x) return false; // out of bound
        if (grid[i][j] != word.charAt(pos)) return false; // do not continue on current path

        grid[i][j] ^= 256; // mark visited to avoid visiting same characters again

        boolean exist = dfs(i, j + 1, pos + 1, word) ||
        dfs(i, j - 1, pos + 1, word) ||
        dfs(i + 1, j, pos + 1, word) ||
        dfs(i - 1, j, pos + 1, word);

        grid[i][j] ^= 256; // reset board
        return exist;
    }
}
