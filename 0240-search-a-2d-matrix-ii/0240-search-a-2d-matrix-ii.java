class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;
        int row = 0, col = m-1;
        while(col>=0 && row <n){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                 row++;
            }
            else{
               col--;
            }
        }

        return false;
    }
}