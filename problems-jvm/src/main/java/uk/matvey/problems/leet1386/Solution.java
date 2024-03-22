package uk.matvey.problems.leet1386;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int families = 0;
        var reserved = Arrays.stream(reservedSeats)
            .collect(Collectors.groupingBy(seat -> seat[0]))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream()
                .map(seat -> seat[1]).collect(Collectors.toSet())));
        for (var row : reserved.values()) {
            if (IntStream.rangeClosed(2, 9).noneMatch(row::contains)) {
                families += 2;
            } else if (IntStream.rangeClosed(2, 5).noneMatch(row::contains) ||
                IntStream.rangeClosed(4, 7).noneMatch(row::contains) ||
                IntStream.rangeClosed(6, 9).noneMatch(row::contains)) {
                families++;
            }
        }
        families += 2 * (n - reserved.size());
        return families;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var matrix = new int[][]{
            {1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}
        };

        int result = new Solution().maxNumberOfFamilies(3, matrix);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        var matrix = new int[][]{
            {2, 1}, {1, 8}, {2, 6}
        };

        int result = new Solution().maxNumberOfFamilies(2, matrix);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        var matrix = new int[][]{
            {4, 3}, {1, 4}, {4, 6}, {1, 7}
        };

        int result = new Solution().maxNumberOfFamilies(4, matrix);

        assertThat(result).isEqualTo(4);
    }
}
