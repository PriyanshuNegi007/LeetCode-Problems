class Solution {
    public int findCircleNum(int[][] isConnected) {
        //isConnected [i][j] = 1 means city i and j are connected
        //isConnected [i][j] = 0 means city i and j are not connected

        int numberOfCities = isConnected.length;
        boolean visited [] = new boolean[numberOfCities];
        int count = 0; // number of provinces

        for(int i = 0; i < numberOfCities; i++){
            if(!visited[i]){ // check if city is visited
                dfs(i, isConnected, visited);
                //Backtrack
                count++;
            }
        }
        return count;
    }

    void dfs(int currentCity,int isConnected [][], boolean visited[]){
        visited[currentCity] = true; //this city is marked visited

        for(int neighbour = 0; neighbour < isConnected.length; neighbour++){
            if(isConnected[currentCity][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, isConnected, visited);
            }
        }
    }
}
