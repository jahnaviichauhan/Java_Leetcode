class Solution {
    public static String nearestPalindromic(String n) {
        int length = n.length();
        if (n.equals("1")) {
            return "0";
        }
        
        // Generate the first half of the number
        long firstHalf = Long.parseLong(n.substring(0, (length + 1) / 2));
        
        // Candidates for the closest palindrome
        Set<Long> candidates = new HashSet<>();
        
        // Case 1: Palindromes by mirroring the first half
        for (long i = -1; i <= 1; i++) {
            String prefix = String.valueOf(firstHalf + i);
            String candidate;
            if (length % 2 == 0) {
                candidate = prefix + new StringBuilder(prefix).reverse().toString();
            } else {
                candidate = prefix + new StringBuilder(prefix.substring(0, prefix.length() - 1)).reverse().toString();
            }
            candidates.add(Long.parseLong(candidate));
        }
        
        // Case 2: Edge cases like "99...99" and "100...001"
        candidates.add((long) Math.pow(10, length - 1) - 1);
        candidates.add((long) Math.pow(10, length) + 1);
        
        // Remove the original number since we need the closest palindrome excluding itself
        long originalNumber = Long.parseLong(n);
        candidates.remove(originalNumber);
        
        // Find the closest palindrome by absolute difference
        long closestPalindrome = -1;
        for (long candidate : candidates) {
            if (closestPalindrome == -1 ||
                Math.abs(candidate - originalNumber) < Math.abs(closestPalindrome - originalNumber) ||
                (Math.abs(candidate - originalNumber) == Math.abs(closestPalindrome - originalNumber) && candidate < closestPalindrome)) {
                closestPalindrome = candidate;
            }
        }
        
        return String.valueOf(closestPalindrome);
    }
}