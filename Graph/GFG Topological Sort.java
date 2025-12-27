class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v); //Directed graph so only this step
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph, i, visited, stack);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        
        for(int element: graph.get(node)){
            if(!visited[element]){
                dfs(graph, element, visited, stack);
            }    
        }
        stack.push(node);
    }
}
