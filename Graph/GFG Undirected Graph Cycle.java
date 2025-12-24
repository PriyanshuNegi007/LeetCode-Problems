class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList());
        }
        
        for(int [] edge:edges){
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, -1, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(int currentNode, int parent, List<List<Integer>> graph, boolean visited[]){
        visited[currentNode] = true;
        
        for(int neighbour: graph.get(currentNode)){
            if(!visited[neighbour]){
                if(dfs(neighbour, currentNode, graph, visited)){
                    return true;
                }
            }
            else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
}
