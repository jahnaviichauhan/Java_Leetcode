class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
         Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int consistentCount = 0;

        // Iterate through each word in words array
        for (String word : words) {
            boolean isConsistent = true;

            // Check if all characters in the word are in the allowed set
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }

            // Increment the count if the word is consistent
            if (isConsistent) {
                consistentCount += 1;
            }
        }

        return consistentCount;
    }
}