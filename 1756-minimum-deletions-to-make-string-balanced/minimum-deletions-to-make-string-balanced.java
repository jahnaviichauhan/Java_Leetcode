class Solution {
    public int minimumDeletions(String s) {
           int n = s.length();
        int count_a = 0;
        int count_b = 0;
        int minDeletions = Integer.MAX_VALUE;

        // Count the total number of 'a's in the string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count_a++;
            }
        }

        minDeletions = Math.min(count_a, n - count_a);

        // Iterate through the string and calculate the minimum deletions
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count_a--;
            } else {
                count_b++;
            }
            // Minimum deletions to make the string balanced
            minDeletions = Math.min(minDeletions, count_a + count_b);
        }

        return minDeletions;
    }
}