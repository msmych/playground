package uk.matvey.problems.leet1354;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        final var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Arrays.stream(target).forEach(queue::offer);
        long longSum = queue.stream().skip(1).mapToLong(n -> n).sum();
        if (longSum > Integer.MAX_VALUE) {
            return false;
        }
        int sum = (int) longSum;
        while (queue.peek() > 1) {
            Integer max = queue.poll();
            if (max > 2 * sum) {
                if (sum > 1 && max % (2 * sum) == 0) {
                    return false;
                }
                int next = max % (2 * sum);
                if (next < queue.peek()) {
                    sum = sum - queue.peek() + next;
                }
                queue.offer(next);
            } else {
                if (max <= sum) {
                    return false;
                }
                int next = max - sum;
                sum = sum - queue.peek() + next;
                queue.offer(next);
            }
        }
        return true;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var target = new int[]{9, 3, 5};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var target = new int[]{1, 1, 1, 2};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        var target = new int[]{8, 5};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        var target = new int[]{1, 1000000000};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case5() {
        var target = new int[]{2, 900000001};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case6() {
        var target = new int[]{1, 1, 999999999};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case7() {
        var target = new int[]{2, 900000002};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }

    @Test
    public void case8() {
        var target = new int[]{5, 50};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }
}
