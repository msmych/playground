package uk.matvey.play.leet1333.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
