// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        final int INF = (int)1e8;
        
        for(int i = 0; i < n; i++){
            for(int src = 0; src < n; src++){
                for(int dst = 0; dst < n; dst++){
                    if(dist[src][i] != INF && dist[i][dst] != INF){
                        dist[src][dst] = Math.min(dist[src][dst], dist[src][i] + dist[i][dst]);
                    }
                }
            }
        }
    }
}
