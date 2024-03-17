package uk.matvey.problems.leet0057;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int start = -1;
        if (intervals[0][0] > newInterval[0]) {
            start = newInterval[0];
        }
        var nextIntervals = new ArrayList<int[]>();
        boolean merged = false;
        for (var interval : intervals) {
            if (!merged && interval[0] > newInterval[1]) {
                if (start == -1) {
                    start = newInterval[0];
                }
                nextIntervals.add(new int[]{start, newInterval[1]});
                nextIntervals.add(interval);
                merged = true;
                continue;
            }
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                nextIntervals.add(interval);
                continue;
            }
            if (start == -1) {
                start = Math.min(interval[0], newInterval[0]);
            }
            if (interval[1] >= newInterval[1]) {
                nextIntervals.add(new int[]{start, interval[1]});
                merged = true;
            }
        }
        if (!merged) {
            nextIntervals.add(start == -1 ? newInterval : new int[]{start, newInterval[1]});
        }
        return nextIntervals.toArray(new int[][]{});
    }
}

class SolutionTest {

    @Test
    void case1() {
        var intervals = new int[][]{
            {1, 3},
            {6, 9}
        };
        var newInterval = new int[]{2, 5};

        var result = new Solution().insert(intervals, newInterval);

        assertThat(result.length).isEqualTo(2);
        assertThat(result).contains(new int[]{1, 5}, atIndex(0));
        assertThat(result).contains(new int[]{6, 9}, atIndex(1));
    }

    @Test
    void case2() {
        var intervals = new int[][]{
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16},
        };
        var newInterval = new int[]{4, 8};

        var result = new Solution().insert(intervals, newInterval);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).contains(new int[]{1, 2}, atIndex(0));
        assertThat(result).contains(new int[]{3, 10}, atIndex(1));
        assertThat(result).contains(new int[]{12, 16}, atIndex(2));
    }
}