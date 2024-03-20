package uk.matvey.problems.leet2050;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        var graph = new HashMap<Integer, Queue<Integer>>();
        var indegree = new int[n];
        for (var relation : relations) {
            graph.putIfAbsent(relation[0] - 1, new LinkedList<>());
            graph.get(relation[0] - 1).offer(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }

        var queue = new LinkedList<Integer>();
        var maxTime = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (var i : graph.getOrDefault(course, new LinkedList<>())) {
                maxTime[i] = Math.max(maxTime[i], maxTime[course] + time[i]);
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return Arrays.stream(maxTime).max().orElse(0);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var relations = new int[][]{{1, 3}, {2, 3}};
        var time = new int[]{3, 2, 5};

        int result = new Solution().minimumTime(3, relations, time);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void case2() {
        var relations = new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        var time = new int[]{1, 2, 3, 4, 5};

        int result = new Solution().minimumTime(5, relations, time);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void case3() {
        var relations = new int[][]{{2, 7}, {2, 6}, {3, 6}, {4, 6}, {7, 6}, {2, 1}, {3, 1}, {4, 1}, {6, 1}, {7, 1}, {3, 8}, {5, 8}, {7, 8}, {1, 9}, {2, 9}, {6, 9}, {7, 9}};
        var time = new int[]{9, 5, 9, 5, 8, 7, 7, 8, 4};

        int result = new Solution().minimumTime(9, relations, time);

        assertThat(result).isEqualTo(32);
    }
}
