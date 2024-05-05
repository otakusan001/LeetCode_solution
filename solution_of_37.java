class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.') continue;
                for(char k = '1'; k <= '9'; k++){
                    if(isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if(backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }   
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char k){
        for(int m = 0; m < 9; m++){
            if(board[i][m] == k) return false;
        }
        for(int n = 0; n < 9; n++){
            if(board[n][j] == k) return false;
        }
        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;
        for (int m = startRow; m < startRow + 3; m++) { // 判断9方格里是否重复
            for (int n = startCol; n < startCol + 3; n++) {
                if (board[m][n] == k ) {
                    return false;
                }
        }
    }
        return true;
    }
}
