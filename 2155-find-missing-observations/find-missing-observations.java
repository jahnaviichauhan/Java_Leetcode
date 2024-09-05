class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        int currentSum = 0;
        
        for (int roll : rolls) {
            currentSum += roll;
        }
        
        int missingSum = totalSum - currentSum;
        
        // Check if it's possible to have the missingSum with n rolls
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        
        int[] result = new int[n];
        int quotient = missingSum / n;
        int remainder = missingSum % n;
        
        for (int i = 0; i < n; i++) {
            result[i] = quotient + (i < remainder ? 1 : 0);
        }
        
        return result;
    }
}