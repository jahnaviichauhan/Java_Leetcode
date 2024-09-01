class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        // Initialize the 2D array
        int[][] result = new int[m][n];

        // Populate the 2D array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result; 
    }
}