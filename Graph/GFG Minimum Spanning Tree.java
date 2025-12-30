class Pair{
    int node;
    int weight;
    
    public Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V];
        int totalWeight = 0;
        
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.weight;
            
            if(visited[node]){
                continue;
            }
            
            visited[node] = true;
            totalWeight = weight + totalWeight;
            
            for(int[] neighbours: graph.get(node)){
                int neighbour = neighbours[0];
                int neighbourWeight = neighbours[1];
                
                if(!visited[neighbour]){
                    pq.add(new Pair(neighbour, neighbourWeight));
                }
            }
        }
        return totalWeight;
    }
}
