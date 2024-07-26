class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
   // Initialize the distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);  // Use a large value to avoid overflow in Floyd-Warshall
            dist[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // Count reachable cities within the distanceThreshold
        int minReachable = Integer.MAX_VALUE;
        int bestCity = -1;
        
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            
            // Update the best city
            if (reachableCount < minReachable) {
                minReachable = reachableCount;
                bestCity = i;
            } else if (reachableCount == minReachable) {
                bestCity = Math.max(bestCity, i);
            }
        }
        
        return bestCity;
    }
}
