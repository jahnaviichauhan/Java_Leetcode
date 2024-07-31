class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
       int n = books.length;
        int[] dp = new int[n + 1];
        
        // Initialize dp array with a large value
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: no books, no height
        dp[0] = 0;
        
        // Iterate through each book
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            // Try to place books[i-1] on the current shelf or start a new shelf
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        
        return dp[n]; 
    }
}