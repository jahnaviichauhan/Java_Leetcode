class Solution {
    private int[] parent; // Array to represent the parent of each element in the Disjoint Set Union (DSU)

    public int removeStones(int[][] stones) {
        int n = 10010; // Representative value for scaling row and column indices
        parent = new int[n << 1]; // Initialize the parent array for the DSU
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i; // Initially, each element is its own parent
        }
        for (int[] stone : stones) {
            // Perform union of stone's row and column by setting the parent of the stone's row to the representative
            // of the stone's adjusted column index
            parent[find(stone[0])] = find(stone[1] + n);
        }
        Set<Integer> uniqueRoots = new HashSet<>(); // Set to store unique roots after unions have been performed
        for (int[] stone : stones) {
            // Add the representative of each stone's row to the set of unique roots
            uniqueRoots.add(find(stone[0]));
        }
        // The number of stones that can be removed is the total number of stones minus the number of unique roots,
        // since each root represents a connected component
        return stones.length - uniqueRoots.size();
    }

    private int find(int x) {
        // Recursively find the root representative of the element `x`. Path compression is applied here to flatten
        // the structure of the tree, effectively speeding up future `find` operations.
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

  