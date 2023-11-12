package uk.matvey.play.leet2642.java1;

import java.util.*;
import java.util.stream.IntStream;

class Graph {

    record Edge(Integer target, Integer weight) {
    }

    private final List<List<Edge>> edges;

    public Graph(int n, int[][] edges) {
        this.edges = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> this.edges.add(new ArrayList<>()));
        Arrays.stream(edges).forEach(this::addEdge);
    }

    public void addEdge(int[] edge) {
        this.edges.get(edge[0]).add(new Edge(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        var queue = new PriorityQueue<List<Integer>>(Comparator.comparingInt(a -> a.get(0)));
        int[] costs = new int[this.edges.size()];
        Arrays.fill(costs, 10_000_000);
        costs[node1] = 0;
        queue.offer(List.of(0, node1));
        while (!queue.isEmpty()) {
            List<Integer> last = queue.poll();
            Integer cost = last.get(0);
            Integer node = last.get(1);
            if (cost > costs[node]) {
                continue;
            }
            if (node == node2) {
                return cost;
            }
            this.edges.get(node).forEach(e -> {
                int nextCost = e.weight + cost;
                if (nextCost < costs[e.target]) {
                    costs[e.target] = nextCost;
                    queue.offer(List.of(nextCost, e.target));
                }
            });
        }
        return -1;
    }
}
