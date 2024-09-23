class Solution {
    public int minExtraChar(String s, String[] dictionary) {
          int n = s.length();
        int[] dp = new int[n + 1];
        
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // By default, consider the current character as extra
            
            for (String word : dictionary) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len]);
                }
            }
        }
        
        return dp[n];  
    }
}