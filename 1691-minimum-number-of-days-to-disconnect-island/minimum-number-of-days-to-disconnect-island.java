class Solution {
private int rows, cols;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minDays(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        // Initial check if the grid is already disconnected
        if (countIslands(grid) != 1) {
            return 0;
        }
        
        // Check if removing a single cell disconnects the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        
        // If the grid is still connected after single cell removal, return 2
        return 2;
    }
    
    private int countIslands(int[][] grid) {
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        for (int[] dir : directions) {
            dfs(grid, visited, i + dir[0], j + dir[1]);
        
    }
}
}