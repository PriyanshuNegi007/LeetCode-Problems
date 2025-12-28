class Pair{
    int node;
    int distance;
    
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            graph.get(u).add(new Pair(v, weight));
            graph.get(v).add(new Pair(u, weight));
        }
            
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE); // Fill distance array with infinity
            
        distance[src] = 0; // src to src shortest distance is always 0
            
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance); //The Pair with the smaller distance has higher priority
            
        pq.add(new Pair(src, 0));
            
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int u = pair.node;
                
            for(Pair neighbour: graph.get(u)){
                int v = neighbour.node;
                int weight = neighbour.distance;
                
               if(distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }
        return distance;   
    }
}
