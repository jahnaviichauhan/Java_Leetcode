class Solution {
    public String decodeAtIndex(String s, int k) {
      long length = 0;

        // Step 1: Calculate the length of the decoded string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                length *= c - '0';  // Multiply the length by the digit value
            } else {
                length++;  // Increment length for a letter
            }
        }

        // Step 2: Work backwards to find the k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                length /= c - '0';  // Divide the length by the digit value
                k %= length;  // Adjust k to fit within the current length
            } else {
                if (k == 0 || k == length) {
                    return String.valueOf(c);  // Found the k-th letter
                }
                length--;  // Decrement length since we processed one letter
            }
        }
        
        throw new IllegalArgumentException("Invalid input");  
    }
}