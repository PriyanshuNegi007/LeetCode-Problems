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
        
       int[] indegree = new int[V]; // Means no. of nodes coming towards it
       
       for(int i = 0; i < V; i++){
           for(int neighbour: graph.get(i)){
               indegree[neighbour]++;
           }
       }
       
       Queue<Integer> queue = new LinkedList<>();
       
       for(int i = 0; i < V; i++){
           if(indegree[i] == 0){
               queue.offer(i);
           }
       }
       
       ArrayList<Integer> result = new ArrayList<>();
       
       while(!queue.isEmpty()){
            int element = queue.poll();
            result.add(element);
           
            for(int neighbour: graph.get(element)){
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        
        if(result.size() != V){
            return new ArrayList<>();
        }
        
        return result;
    }
}
