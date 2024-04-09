package uk.matvey.problems.leet1443;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var map = Arrays.stream(edges)
            .collect(Collectors.toMap(edge -> edge[1], edge -> edge[0]));
        int time = 0;
        for (int i = 0; i < hasApple.size(); i++) {
            if (!hasApple.get(i)) {
                continue;
            }
            int parent = i;
            while (parent != 0 && map.containsKey(parent)) {
                var node = map.get(parent);
                map.remove(parent);
                parent = node;
                time += 2;
            }
        }
        return time;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        var hasApple = List.of(false, false, true, false, true, true, false);

        var result = new Solution().minTime(7, edges, hasApple);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case2() {
        var edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        var hasApple = List.of(false, false, true, false, false, true, false);

        var result = new Solution().minTime(7, edges, hasApple);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case3() {
        var edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        var hasApple = List.of(false, false, false, false, false, false, false);

        var result = new Solution().minTime(7, edges, hasApple);

        assertThat(result).isEqualTo(0);
    }
}
