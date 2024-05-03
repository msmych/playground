package uk.matvey.problems.leet0834;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private int[] counts;
    private int[] sums;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.counts = new int[n];
        this.sums = new int[n];
        Arrays.fill(this.counts, 1);
        
        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (var edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        setupCounts(0, -1);
        setupSums(0, -1);

        return this.sums;
    }

    private void setupCounts(int node, int parent) {
        for (var child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            setupCounts(child, node);
            this.counts[node] += this.counts[child];
            this.sums[node] += this.sums[child] + this.counts[child];
        }
    }

    private void setupSums(int node, int parent) {
        for (var child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            this.sums[child] = this.sums[node] - this.counts[child] + this.counts.length - this.counts[child];
            setupSums(child, node);
        }
    }
}

class SolutionTest {

    @Test
    void case1() {
        var edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};

        var result = new Solution().sumOfDistancesInTree(6, edges);

        assertThat(result).containsExactly(8, 12, 6, 10, 10, 10);
    }

    @Test
    void case2() {
        var edges = new int[][]{};

        var result = new Solution().sumOfDistancesInTree(1, edges);

        assertThat(result).containsExactly(0);
    }

    @Test
    void case3() {
        var edges = new int[][]{{1, 0}};

        var result = new Solution().sumOfDistancesInTree(2, edges);

        assertThat(result).containsExactly(1, 1);
    }
}
