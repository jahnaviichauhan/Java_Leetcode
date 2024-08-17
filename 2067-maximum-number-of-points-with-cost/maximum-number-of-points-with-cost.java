class Solution {
    public long maxPoints(int[][] points) {
 int m = points.length;
        int n = points[0].length;

        // Initialize dp array with the first row values
        long[] dp = new long[n];
        for (int c = 0; c < n; c++) {
            dp[c] = points[0][c];
        }

        // Iterate through each row starting from the second row
        for (int r = 1; r < m; r++) {
            long[] newDp = new long[n];

            // Compute the left-to-right max points
            long[] left = new long[n];
            left[0] = dp[0];
            for (int c = 1; c < n; c++) {
                left[c] = Math.max(left[c - 1] - 1, dp[c]);
            }

            // Compute the right-to-left max points
            long[] right = new long[n];
            right[n - 1] = dp[n - 1];
            for (int c = n - 2; c >= 0; c--) {
                right[c] = Math.max(right[c + 1] - 1, dp[c]);
            }

            // Update dp for the current row
            for (int c = 0; c < n; c++) {
                newDp[c] = points[r][c] + Math.max(left[c], right[c]);
            }

            // Update dp array for the next iteration
            dp = newDp;
        }

        // Find the maximum value in the dp array
        long maxPoints = 0;
        for (long pointsValue : dp) {
            maxPoints = Math.max(maxPoints, pointsValue);
        }

        return maxPoints;
    }
}