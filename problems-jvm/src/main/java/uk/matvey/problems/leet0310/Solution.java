package uk.matvey.problems.leet0310;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        var nodes = new HashMap<Integer, Set<Integer>>();
        for (var edge : edges) {
            if (!nodes.containsKey(edge[0])) {
                nodes.put(edge[0], new HashSet<>());
            }
            nodes.get(edge[0]).add(edge[1]);
            if (!nodes.containsKey(edge[1])) {
                nodes.put(edge[1], new HashSet<>());
            }
            nodes.get(edge[1]).add(edge[0]);
        }
        var leaves = nodes.entrySet().stream()
            .filter(e -> e.getValue().size() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
        while (n > 2) {
            n -= leaves.size();
            var nextLeaves = new HashSet<Integer>();
            for (int leaf : leaves) {
                int node = nodes.get(leaf).iterator().next();
                nodes.get(node).remove(leaf);
                if (nodes.get(node).size() == 1) {
                    nextLeaves.add(node);
                }
            }
            leaves = nextLeaves;
        }
        return new ArrayList<>(leaves);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};

        var result = new Solution().findMinHeightTrees(4, edges);

        assertThat(result).containsExactlyInAnyOrder(1);
    }

    @Test
    void case2() {
        var edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

        var result = new Solution().findMinHeightTrees(6, edges);

        assertThat(result).containsExactlyInAnyOrder(3, 4);
    }

    @Test
    void case3() {
        var edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        var result = new Solution().findMinHeightTrees(6, edges);

        assertThat(result).containsExactlyInAnyOrder(3);
    }

    @Test
    void case4() {
        var edges = new int[][]{};

        var result = new Solution().findMinHeightTrees(1, edges);

        assertThat(result).containsExactlyInAnyOrder(0);
    }
}
