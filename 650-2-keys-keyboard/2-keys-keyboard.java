class Solution {
    public int minSteps(int n) {
 int[] dp = new int[n + 1];
        
        // The minimum steps to get 1 'A' is 0 because we already start with 1 'A'
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Set a maximum value, i.e., we could just press Paste i-1 times
            for (int j = i / 2; j >= 1; j--) {
                if (i % j == 0) { // j can be copied and pasted to form i
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        
        return dp[n];
    }
}