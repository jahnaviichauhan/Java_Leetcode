class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        int[][] result = new int[rows * cols][2];
        boolean[][] visited = new boolean[rows][cols];
        
        int x = rStart, y = cStart;
        int directionIndex = 0;
        int steps = 1;
        int index = 0;
        
        result[index++] = new int[]{x, y};
        visited[x][y] = true;
        
        while (index < rows * cols) {
            for (int i = 0; i < 2; ++i) { // Two times for each direction change
                for (int j = 0; j < steps; ++j) {
                    x += directions[directionIndex][0];
                    y += directions[directionIndex][1];
                    
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                        result[index++] = new int[]{x, y};
                        visited[x][y] = true;
                    }
                }
                directionIndex = (directionIndex + 1) % 4; // Change direction
            }
            steps++; // Increase the steps after two direction changes
        }
        
        return result;
    }
}