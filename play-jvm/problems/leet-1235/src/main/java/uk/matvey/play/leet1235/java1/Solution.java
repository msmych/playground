package uk.matvey.play.leet1235.java1;

import java.util.Comparator;
import java.util.stream.IntStream;

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
