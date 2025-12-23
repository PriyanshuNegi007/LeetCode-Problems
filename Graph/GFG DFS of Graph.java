class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        final int V = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited [] = new boolean [V];
      
        helper(0, adj, visited, result);
    
        return result;   
    }
    
    void helper(int nodeIndex, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> result){
        // mark first vertex as visited
        visited[nodeIndex] = true;
        result.add(nodeIndex);
        
        //explore neighbours
        for(int neighbour : adj.get(nodeIndex)){
            if(!visited[neighbour]){
                helper(neighbour, adj, visited, result);
            }
        }
    }
}
