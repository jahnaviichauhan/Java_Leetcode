class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> bitmaskIndexMap = new HashMap<>();
        // Initialize the bitmask for all vowels even (00000) at index -1
        bitmaskIndexMap.put(0, -1);
        
        // Current bitmask representing the parity of vowels
        int bitmask = 0;
        // Maximum length of the substring with even counts of vowels
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Update the bitmask based on the current character
            switch (c) {
                case 'a':
                    bitmask ^= (1 << 0);
                    break;
                case 'e':
                    bitmask ^= (1 << 1);
                    break;
                case 'i':
                    bitmask ^= (1 << 2);
                    break;
                case 'o':
                    bitmask ^= (1 << 3);
                    break;
                case 'u':
                    bitmask ^= (1 << 4);
                    break;
            }
            
            // If the bitmask has been seen before, calculate the length of the substring
            if (bitmaskIndexMap.containsKey(bitmask)) {
                int prevIndex = bitmaskIndexMap.get(bitmask);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this bitmask
                bitmaskIndexMap.put(bitmask, i);
            }
        }
        
        return maxLength;
    }
}