package uk.matvey.play.leet1345.java1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] == arr[arr.length - 1]) {
            return 1;
        }
        if (arr[0] == arr[arr.length - 2]) {
            return 2;
        }
        Map<Integer, List<Integer>> map = IntStream.range(0, arr.length).boxed().collect(Collectors.groupingBy(i -> arr[i]));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        int jumps = 0;
        while (!queue.isEmpty()) {
            for (int q = queue.size(); q > 0; q--) {
                Integer i = queue.poll();
                if (i == arr.length - 1) {
                    return jumps;
                }
                visited.add(i);
                if (i > 0 && !visited.contains(i - 1)) {
                    queue.offer(i - 1);
                }
                if (i < arr.length - 1 && !visited.contains(i + 1)) {
                    queue.offer(i + 1);
                }
                int n = arr[i];
                for (Integer next : map.get(n)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}
