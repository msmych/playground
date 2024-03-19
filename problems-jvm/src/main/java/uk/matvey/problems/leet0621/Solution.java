package uk.matvey.problems.leet0621;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        var schedule = new int[26];
        for (var task : tasks) {
            schedule[task - 'A']++;
        }
        Arrays.sort(schedule);
        int max = schedule[25] - 1, idle = max * n;
        for (int i = 24; i >= 0 && schedule[i] > 0; i--) {
            idle -= Math.min(schedule[i], max);
        }
        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};

        int result = new Solution().leastInterval(tasks, 2);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case2() {
        var tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};

        int result = new Solution().leastInterval(tasks, 0);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case3() {
        var tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int result = new Solution().leastInterval(tasks, 2);

        assertThat(result).isEqualTo(16);
    }
}
