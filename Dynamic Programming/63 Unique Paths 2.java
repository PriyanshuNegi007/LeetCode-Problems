/*class Solution {
    //Memoization Approach
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
         if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        Integer dp[][]= new Integer[m][n];
        return helper(obstacleGrid,0,0, m-1, n-1, dp);
    }

    public int helper(int[][] obstacleGrid, int startRow, int startCol, int endRow, int endCol, Integer dp[][]){
        if(startRow == endRow && startCol == endCol){
            return 1;
        }

        if(startRow > endRow || startCol > endCol || obstacleGrid[startRow][startCol] == 1){
            return 0;
        }

        if(dp[startRow][startCol] != null){
            return dp[startRow][startCol];
        }

        int down = helper(obstacleGrid, startRow + 1, startCol, endRow, endCol,dp);
        int right = helper(obstacleGrid, startRow, startCol+1, endRow, endCol, dp);
        return dp[startRow][startCol] = down + right;

    } 
} */

//Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }

        for(int i = 1; i < n; i++){ // Fill first row with 1
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = dp[0][i - 1];
            }
        }

        for(int i = 1; i < m; i++){  //Fill first col with 1
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = dp[i - 1][0];
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
