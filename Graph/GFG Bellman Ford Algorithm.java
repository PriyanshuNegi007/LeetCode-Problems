class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int [] distance = new int[V];
        Arrays.fill(distance, (int)1e8); // 1e8 = 10**8
        distance[src] = 0;
        
        for(int i = 0; i < V-1; i++){
            for(int edge[]: edges){
                int u = edge[0], v = edge[1], weight = edge[2];
            
                if(distance[u] != (int)1e8 && distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                }
            }
        }
        //Check for negative cycle
        for(int edge[]: edges){
                int u = edge[0], v = edge[1], weight = edge[2];
            
                if(distance[u] != (int)1e8 && distance[u] + weight < distance[v]){
                    return new int[]{-1};
                
                }
        }
        return distance;
    }
}
