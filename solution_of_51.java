class Solution {
    private char[][] buildChessboard(int n){
        char[][] chessboard = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                chessboard[i][j] = '.';
            }
        return chessboard;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = buildChessboard(n);
        backtracking(chessboard, n, 0);
        return res;
    }

    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private void backtracking(char[][] chessboard, int n, int row){
        if(row == n){
            for(int k = 0; k < n; k++){
                path.add(new String(chessboard[k]));
                //System.out.println(path);
            }
            //System.out.println(path);
            res.add(new ArrayList(path));
            path.clear();
            //res.clear();
            return;
        }
        for(int j = 0; j < n; j++){
            if(isValid(chessboard, row, j)){
                chessboard[row][j] = 'Q';
                backtracking(chessboard, n, row+1);
                chessboard[row][j] = '.';
            }
        }
    }
    private boolean isValid(char[][] chessboard, int row, int col){
        for(int i = 0; i < row; i++){
            if(chessboard[i][col] == 'Q') return false;
        }
        for(int i = row -1, j = col - 1; i >= 0 && j >= 0; i--,j--){
            if(chessboard[i][j] == 'Q') return false;
        }
        for(int i = row -1, j = col + 1; i >= 0 && j < chessboard[0].length; i--,j++){
            if(chessboard[i][j] == 'Q') return false;
        }
        return true;
    }
}
