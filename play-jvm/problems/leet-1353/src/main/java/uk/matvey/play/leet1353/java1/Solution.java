package uk.matvey.play.leet1353.java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
        var queue = new PriorityQueue<Integer>();
        Arrays.sort(events, Comparator.comparingInt(event -> event[0]));
        int attended = 0;
        for (int day = 1, i = 0; day <= 100000; day++) {
            while (queue.size() > 0 && queue.peek() < day) {
                queue.poll();
            }
            while (i < events.length && events[i][0] == day) {
                queue.offer(events[i++][1]);
            }
            if (queue.size() > 0) {
                queue.poll();
                attended++;
            }
        }
        return attended;
    }
}
