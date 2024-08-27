

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
    }}

