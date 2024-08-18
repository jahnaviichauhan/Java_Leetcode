class Solution {
    public int nthUglyNumber(int n) {
         if (n <= 0) return 0;
        if (n == 1) return 1;

        // Min-heap to keep track of the next smallest ugly number
        PriorityQueue<Long> heap = new PriorityQueue<>();
        // Set to avoid duplicates
        Set<Long> seen = new HashSet<>();

        // Initial ugly number
        heap.offer(1L);
        seen.add(1L);

        // Factors to generate new ugly numbers
        int[] factors = {2, 3, 5};

        long currentUgly = 1L;
        for (int i = 1; i <= n; i++) {
            // Extract the smallest number from the heap
            currentUgly = heap.poll();

            // Generate new ugly numbers by multiplying with factors
            for (int factor : factors) {
                long newUgly = currentUgly * factor;
                if (!seen.contains(newUgly)) {
                    heap.offer(newUgly);
                    seen.add(newUgly);
                }
            }
        }

        // The nth ugly number
        return (int) currentUgly;
    }
}