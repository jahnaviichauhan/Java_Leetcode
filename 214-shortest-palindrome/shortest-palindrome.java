class Solution {
    public String shortestPalindrome(String s) {
         String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        
        int[] lps = computeLPSArray(combined);
        
        int toAdd = s.length() - lps[lps.length - 1];
        String prefix = reversed.substring(0, toAdd);
        
        return prefix + s;
    }

    private static int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}