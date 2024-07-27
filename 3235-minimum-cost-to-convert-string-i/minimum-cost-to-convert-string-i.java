class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int n = source.length();
        int m = original.length;

        // Step 1: Initialize the transformation cost matrix
        long[][] transformCost = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(transformCost[i], Long.MAX_VALUE);
            transformCost[i][i] = 0; // Cost to transform a character to itself is 0
        }

        // Step 2: Fill the transformation cost matrix with given transformations
        for (int i = 0; i < m; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            transformCost[from][to] = Math.min(transformCost[from][to], cost[i]);
        }

        // Step 3: Use Floyd-Warshall algorithm to find the minimum cost for all transformations
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (transformCost[i][k] != Long.MAX_VALUE && transformCost[k][j] != Long.MAX_VALUE) {
                        transformCost[i][j] = Math.min(transformCost[i][j], transformCost[i][k] + transformCost[k][j]);
                    }
                }
            }
        }

        // Step 4: Compute the total transformation cost
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);

            if (srcChar == tgtChar) {
                continue;
            }

            long minCost = transformCost[srcChar - 'a'][tgtChar - 'a'];

            // If no valid transformation was found
            if (minCost == Long.MAX_VALUE) {
                return -1;
            }

            totalCost += minCost;
        }

        return totalCost;
    }
}