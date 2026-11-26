class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];
        if(ogColor==color){
            return image;
        }
        dfs(image,sr,sc,ogColor,color);
        return image;
    }
    public void dfs(int[][] img, int i, int j, int ogColor, int color){
        if(i<0 || j<0 || i>=img.length || j>=img[0].length || img[i][j]!=ogColor){
            return;
        }
        img[i][j]=color;
        dfs(img,i+1,j,ogColor,color);
        dfs(img,i-1,j,ogColor,color);
        dfs(img,i,j+1,ogColor,color);
        dfs(img,i,j-1,ogColor,color);
    }
}