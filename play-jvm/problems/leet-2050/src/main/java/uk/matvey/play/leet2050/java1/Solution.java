package uk.matvey.play.leet2050.java1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        var graph = new HashMap<Integer, Queue<Integer>>();
        var indegree = new int[n];
        for (int[] relation : relations) {
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
            for (Integer i : graph.getOrDefault(course, new LinkedList<>())) {
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
