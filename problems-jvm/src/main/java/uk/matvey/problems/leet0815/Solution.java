package uk.matvey.problems.leet0815;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        var stationsByRoute = new HashMap<Integer, Set<Integer>>();
        var routesByStation = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < routes.length; i++) {
            stationsByRoute.put(i, Arrays.stream(routes[i]).boxed().collect(Collectors.toSet()));
            for (int j = 0; j < routes[i].length; j++) {
                routesByStation.putIfAbsent(routes[i][j], new HashSet<>());
                routesByStation.get(routes[i][j]).add(i);
            }
        }
        var queue = new LinkedList<Integer>();
        var visited = new HashSet<Integer>();
        routesByStation.get(source).forEach(route -> {
            queue.offer(route);
            visited.add(route);
        });
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            for (int len = queue.size(); len > 0; len--) {
                Integer route = queue.poll();
                Set<Integer> stations = stationsByRoute.get(route);
                if (stations.contains(target)) {
                    return count;
                }
                stations.stream()
                    .flatMap(station -> routesByStation.get(station).stream())
                    .filter(nextRoute -> !visited.contains(nextRoute))
                    .forEach(nextRoute -> {
                        queue.offer(nextRoute);
                        visited.add(nextRoute);
                    });
            }
        }
        return -1;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var routes = new int[][]{{1, 2, 7}, {3, 6, 7}};

        var result = new Solution().numBusesToDestination(routes, 1, 6);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var routes = new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};

        var result = new Solution().numBusesToDestination(routes, 15, 12);

        assertThat(result).isEqualTo(-1);
    }
}
