package uk.matvey.play.leet1354.java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
