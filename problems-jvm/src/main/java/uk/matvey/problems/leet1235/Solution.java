package uk.matvey.problems.leet1235;

import java.util.Comparator;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private record Job(
        int startTime,
        int endTime,
        int profit
    ) {
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        var n = startTime.length;

        final var jobs = IntStream.range(0, n)
            .mapToObj(i -> new Job(startTime[i], endTime[i], profit[i]))
            .sorted(Comparator.comparingInt(Job::endTime))
            .toList();
        final var ends = jobs.stream().mapToInt(Job::endTime).toArray();
        var dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            final var job = jobs.get(i);
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (ends[mid] <= job.startTime()) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[i + 1] = Math.max(dp[i], dp[left] + job.profit());
        }
        return dp[n];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var startTime = new int[]{1, 2, 3, 3};
        var endTime = new int[]{3, 4, 5, 6};
        var profit = new int[]{50, 10, 40, 70};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(120);
    }

    @Test
    public void case2() {
        var startTime = new int[]{1, 2, 3, 4, 6};
        var endTime = new int[]{3, 5, 10, 6, 9};
        var profit = new int[]{20, 20, 100, 70, 60};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(150);
    }

    @Test
    public void case3() {
        var startTime = new int[]{1, 1, 1};
        var endTime = new int[]{2, 3, 4};
        var profit = new int[]{5, 6, 4};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(6);
    }
}
