package uk.matvey.problems.leet2402;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int mostBooked(int n, int[][] meetings) {
        var counts = new int[n];
        var used = new PriorityQueue<>(Comparator.comparingLong((long[] a) -> a[0]).thenComparingLong((long[] a) -> a[1]));
        var unused = new PriorityQueue<Integer>();
        IntStream.range(0, n).forEach(unused::offer);
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));
        Arrays.stream(meetings).forEach(meeting -> {
            int start = meeting[0];
            int end = meeting[1];
            while (!used.isEmpty() && used.peek()[0] <= start) {
                int room = (int) used.poll()[1];
                unused.offer(room);
            }
            if (!unused.isEmpty()) {
                int room = unused.poll();
                used.offer(new long[]{end, room});
                counts[room]++;
            } else {
                final var time = used.peek()[0];
                int room = (int) used.poll()[1];
                used.offer(new long[]{time + end - start, room});
                counts[room]++;
            }
        });
        int maxCount = 0;
        int maxRoom = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var meetings = new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}};

        final var result = new Solution().mostBooked(2, meetings);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case2() {
        var meetings = new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};

        final var result = new Solution().mostBooked(3, meetings);

        assertThat(result).isEqualTo(1);
    }
}
