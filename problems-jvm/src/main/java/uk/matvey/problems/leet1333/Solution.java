package uk.matvey.problems.leet1333;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
            .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
            .filter(restaurant -> restaurant[3] <= maxPrice)
            .filter(restaurant -> restaurant[4] <= maxDistance)
            .sorted((a, b) -> a[1] == b[1] ? Long.compare(b[0], a[0]) : Long.compare(b[1], a[1]))
            .map(restaurant -> restaurant[0])
            .toList();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var restaurants = new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};

        List<Integer> result = new Solution().filterRestaurants(restaurants, 1, 50, 10);

        assertThat(result).containsExactly(3, 1, 5);
    }

    @Test
    public void case2() {
        var restaurants = new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};

        List<Integer> result = new Solution().filterRestaurants(restaurants, 0, 50, 10);

        assertThat(result).containsExactly(4, 3, 2, 1, 5);
    }

    @Test
    public void case3() {
        var restaurants = new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};

        List<Integer> result = new Solution().filterRestaurants(restaurants, 0, 30, 3);

        assertThat(result).containsExactly(4, 5);
    }
}
