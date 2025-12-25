class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        
        if(currentColor == color){ // if color is same just return grid
            return image;
        }
        // if color is different do something
        dfs(image, sr, sc, color, currentColor);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int newColor, int orignalColor){
        //Base Case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orignalColor){
            return;
        }

        image[sr][sc] = newColor; // Mark as visited

        dfs(image, sr + 1, sc, newColor, orignalColor);
        dfs(image, sr - 1, sc, newColor, orignalColor);
        dfs(image, sr, sc + 1, newColor, orignalColor);
        dfs(image, sr, sc - 1, newColor, orignalColor);
    }
}
