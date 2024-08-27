

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create the graph as an adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new Pair(b, prob));
            graph.get(b).add(new Pair(a, prob));
        }

        // Max-heap priority queue to store (probability, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start_node, 1.0));

        // Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;

            if (node == end_node) {
                return prob;
            }

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;

                // If we found a path with a higher probability, update and push to the queue
                if (maxProb[nextNode] < prob * nextProb) {
                    maxProb[nextNode] = prob * nextProb;
                    pq.offer(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }

        return 0.0;
    }

    // Helper class to store node and probability pairs
    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.println(solution.maxProbability(n1, edges1, succProb1, start1, end1)); // Output: 0.25000

        // Example 2
        int n2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        int start2 = 0;
        int end2 = 2;
        System.out.println(solution.maxProbability(n2, edges2, succProb2, start2, end2)); // Output: 0.30000

        // Example 3
        int n3 = 3;
        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;
        System.out.println(solution.maxProbability(n3, edges3, succProb3, start3, end3)); // Output: 0.00000
    }
}