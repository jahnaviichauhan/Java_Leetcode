class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numericString = new StringBuilder();
        for (char c : s.toCharArray()) {
            int position = c - 'a' + 1;
            numericString.append(position);
        }

        // Step 2: Transform the integer by summing its digits k times
        String currentString = numericString.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char digit : currentString.toCharArray()) {
                sum += digit - '0';
            }
            currentString = String.valueOf(sum);
        }

        // Return the resulting integer after k transformations
        return Integer.parseInt(currentString);
    }
}