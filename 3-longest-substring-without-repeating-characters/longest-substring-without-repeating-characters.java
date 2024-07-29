class Solution {
    public int lengthOfLongestSubstring(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                // Move the left pointer to the right of the last occurrence of currentChar
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the last occurrence of currentChar
            map.put(currentChar, right);

            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}