class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
    List<Integer> subarraySums = new ArrayList<>();
        
        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }
        
        // Sort the subarray sums
        Collections.sort(subarraySums);
        
        // Calculate the sum of elements from index left to right (1-based index)
        int mod = 1_000_000_007;
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % mod;
        }
        
        return (int) result;
    }
}