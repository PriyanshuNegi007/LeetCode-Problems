class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == '1'){ // is there land?
                    count++;
                    //call all directions
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j){
        //Base Case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0'; //Mark current cell visited

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
