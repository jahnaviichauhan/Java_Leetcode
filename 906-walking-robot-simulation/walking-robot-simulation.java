class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
              // Directions: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0; // Robot's initial position
        int direction = 0; // Initially facing North
        int maxDistanceSquared = 0;

        // Convert obstacles array to a set of strings for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process each command
        for (int command : commands) {
            if (command == -2) {
                // Turn left 90 degrees
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                // Turn right 90 degrees
                direction = (direction + 1) % 4;
            } else {
                // Move forward k units
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    // Check if the next position is an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                    } else {
                        // Stop moving if there's an obstacle
                        break;
                    }
                }
            }
        }

        return maxDistanceSquared;  
    }
}