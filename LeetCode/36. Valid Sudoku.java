class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        //Print2DArr
        /*for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }*/
        
        for(int l = 0; l < 9; l+= 3) {
            for(int k = 0; k < 9; k+=3) {
                for(int i = l; i < l + 3; i++) {
                    for(int j = k; j < k + 3; j++) {
                        if(board[i][j] != '.') {
                            int x = (int) board[i][j];
                             if(!set.contains(x)) {
                                set.add(x);
                            } else {
                                return false;
                            }
                        }
                    }
                           
                }
                set.clear();
            }
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int x = (int) board[i][j];
                     if(!set.contains(x)) {
                        set.add(x);
                    } else {
                        return false;
                    }
                }
                if(board[j][i] != '.') {
                    int x = (int) board[j][i];
                     if(!set2.contains(x)) {
                        set2.add(x);
                    } else {
                        return false;
                    }
                }
            }
            set.clear();       
            set2.clear();
        }
        
    return true;
                   
    }
}

/***

TODO:

Make it efficient by looping only 9 * 9 = 81 times instead of (9 * 9 * 9 * 9 + 9 * 9) = 6642 times


***/