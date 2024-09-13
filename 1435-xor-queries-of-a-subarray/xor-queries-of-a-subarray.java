class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        // Step 1: Create a prefix XOR array
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        
        // Compute the prefix XOR for the rest of the array
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        
        int[] result = new int[queries.length];
        
        // Step 2: For each query, compute the XOR for the subarray
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            if (left == 0) {
                // If the range starts from index 0, result is just prefixXOR[right]
                result[i] = prefixXOR[right];
            } else {
                // Otherwise, use the formula: prefixXOR[right] ^ prefixXOR[left-1]
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }
        
        return result;
    }
}