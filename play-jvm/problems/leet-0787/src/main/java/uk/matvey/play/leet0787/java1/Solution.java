package uk.matvey.play.leet0787.java1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var graph = new HashMap<Integer, Set<Integer>>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashSet<>());
            graph.get(flight[0]).add(flight[1]);
        }
        var flightsCosts = Arrays.stream(flights)
            .collect(Collectors.toUnmodifiableMap(f -> new Flight(f[0], f[1]), f -> f[2]));
        var queue = new ArrayDeque<CityCost>();
        queue.offer(new CityCost(src, 0));
        var minCosts = new HashMap<Integer, Integer>();
        for (; k >= 0; k--) {
            for (int len = queue.size(); len > 0; len--) {
                var cityCost = queue.poll();
                for (Integer nextCity : graph.getOrDefault(cityCost.city, Set.of())) {
                    Integer nextCost = flightsCosts.get(new Flight(cityCost.city, nextCity));
                    if (nextCost >= minCosts.getOrDefault(nextCity, 99_999)) {
                        continue;
                    }
                    var nextCityCost = new CityCost(nextCity, nextCost);
                    minCosts.put(nextCity, cityCost.cost + nextCost);
                    queue.offer(nextCityCost);
                }
            }
        }
        return minCosts.getOrDefault(dst, -1);
    }

    private record Flight(int from, int to) {
    }

    private record CityCost(int city, int cost) {
    }
}
