class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength == 0) {
            return 0; // If needle is empty, return 0 as per the problem statement
        }

        if (haystackLength < needleLength) {
            return -1; // If haystack is shorter than needle, needle cannot be found
        }

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Mismatch found, break out of the inner loop
                }
            }
            if (j == needleLength) {
                return i; // If we complete the inner loop, we found the needle at index i
            }
        }

        return -1; // If we complete the outer loop without finding the needle, return -1
    }
}
