class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);

    }
    static boolean solve(char[][] mat){
        for(int i =0; i<9;i++){
            for(int j =0; j<9; j++){
                if(mat[i][j]=='.'){
                    for(char num ='1'; num<='9'; num++){
                        if(isValid(mat,i,j,num)){
                            mat[i][j]=num;
                            if(solve(mat)) return true;
                            mat[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(char[][] mat, int row, int col , int num){
        for(int i =0; i<9; i++){
            if(mat[row][i]==num) return false;
        }
        for(int j=0; j<9; j++){
            if(mat[j][col]==num) return false;
        }
        int r =row - row%3;
        int c = col- col%3;
        for(int i =r; i<r+3; i++){
            for(int j =c; j<c+3;j++){
                if(mat[i][j]==num) return false;
            }
        }
        return true;
    }
}