class Solution {
    public void backtrack(int[][] image,int sr,int sc,int color,int original){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=original){
            return;
        }
        image[sr][sc]=color;
        backtrack(image,sr+1,sc,color,original);
        backtrack(image,sr-1,sc,color,original);
        backtrack(image,sr,sc+1,color,original);
        backtrack(image,sr,sc-1,color,original);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]!=color){
            int original= image[sr][sc];
            backtrack(image,sr,sc,color,original);
        }
        return image;
        
    }
}