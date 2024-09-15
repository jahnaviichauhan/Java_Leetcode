class Solution {
    public int longestSubarray(int[] nums) {

        // Step 1: Find the maximum value in the array
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // Step 2: Find the longest subarray where all elements are equal to maxVal
        int maxLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}