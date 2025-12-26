class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int freshOrangeCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    freshOrangeCount++;
                }
            }
        }
        if(freshOrangeCount == 0){
            return 0;
        }

        int minutes = 0;
        int directions [][] = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++){
                int orangePosition[] = queue.poll();
                int r = orangePosition[0];
                int c = orangePosition[1];

                //check all directions
                for(int [] direction: directions){
                    int newRowDirection = r + direction[0];
                    int newColumnDirection = c + direction[1];

                    if(newRowDirection >= 0 && newRowDirection < rows && newColumnDirection >=0 && newColumnDirection < columns && grid[newRowDirection][newColumnDirection] == 1){
                        grid[newRowDirection][newColumnDirection] = 2;
                        queue.add(new int[]{newRowDirection, newColumnDirection});
                        freshOrangeCount--;
                        isRotten = true;
                    }
                } 
            }
            if(isRotten){
                minutes++;
            }
        }
        return freshOrangeCount == 0 ? minutes: -1;
    }
}
