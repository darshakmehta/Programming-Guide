public class TicTacToe {
	int[][] board;

	public TicTacToe(int n) {
		board = new int[n][n];
	}

	/** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
	public int move(int row, int col, int player) {
		board[row][column] = player;

		// check row
		boolean win = true;
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] != player) {
				win = false;
				break;
			}
		}

		if(win) return player;

		// check column
		win = true;
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] != player) {
				win = false;
				break;
			}
		}

		if(win) return player;

		// check back diagonal
		win = true;
		for(int i = 0; i < board.length; i++) {
			if(board[i][i] != player) {
				win = false;
				break;
			}
		}

		if(win) return player;

		// check forward diagonal
		win = true;
		for(int i = 0; i < board.length; i++) {
			if(board[i][board.length - i - 1] != player) {
				win = false;
				break;
			}
		}

		if(win) return player;

		return 0;
	}
}

public class TicTacToe {
    int[] rows;
    int[] cols;
    int dc1;
    int dc2;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }
 
    
    public int move(int row, int col, int player) {
        int playerNumber = (player == 1 ? 1 : -1);
 
        rows[row] += playerNumber;
        cols[col] += playerNumber;
 
        if(row == col){
            dc1 += playerNumber;
        }
        if(col == n - row - 1){
            dc2 += playerNumber;
        }
 
        if(Math.abs(rows[row])==n 
        || Math.abs(cols[col])==n 
        || Math.abs(dc1)==n 
        || Math.abs(dc2)==n){
            return player;
        }
 
        return 0;
    }
}


/***

TODO: Understand Solution 2 and write Comments

References:
1. https://www.programcreek.com/2014/05/leetcode-tic-tac-toe-java/

***/