package uk.matvey.problems.leet0787;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;
import static org.assertj.core.api.Assertions.assertThat;

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
                    final var costSum = cityCost.cost + nextCost;
                    if (costSum >= minCosts.getOrDefault(nextCity, 99_999)) {
                        continue;
                    }
                    var nextCityCost = new CityCost(nextCity, costSum);
                    minCosts.put(nextCity, costSum);
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

class SolutionTest {

    @Test
    public void case1() {
        var flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int result = new Solution().findCheapestPrice(3, flights, 0, 2, 1);

        assertThat(result).isEqualTo(200);
    }

    @Test
    public void case2() {
        var flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int result = new Solution().findCheapestPrice(3, flights, 0, 2, 0);

        assertThat(result).isEqualTo(500);
    }

    @Test
    public void case3() {
        var flights = new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};

        int result = new Solution().findCheapestPrice(5, flights, 2, 1, 1);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void case4() {
        var flights = new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}};

        int result = new Solution().findCheapestPrice(10, flights, 6, 0, 7);

        assertThat(result).isEqualTo(14);
    }

    @Test
    public void case5() {
        var flights = new TestCaseReader("leet0787/case5").parseIntArrArr("flights.txt");

        int result = new Solution().findCheapestPrice(13, flights, 10, 1, 10);

        assertThat(result).isEqualTo(-1);
    }
}
