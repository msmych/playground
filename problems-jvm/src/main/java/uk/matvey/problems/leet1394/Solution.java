package uk.matvey.problems.leet1394;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int findLucky(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)))
            .entrySet().stream()
            .filter(e -> e.getKey() == e.getValue())
            .map(Map.Entry::getKey).max(Comparator.naturalOrder())
            .orElse(-1);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var arr = new int[]{2, 2, 3, 4};

        assertThat(new Solution().findLucky(arr)).isEqualTo(2);
    }

    @Test
    void case2() {
        var arr = new int[]{1, 2, 2, 3, 3, 3};

        assertThat(new Solution().findLucky(arr)).isEqualTo(3);
    }

    @Test
    void case3() {
        var arr = new int[]{2, 2, 2, 3, 3};

        assertThat(new Solution().findLucky(arr)).isEqualTo(-1);
    }

    @Test
    void case4() {
        var arr = new int[]{5};

        assertThat(new Solution().findLucky(arr)).isEqualTo(-1);
    }

    @Test
    void case5() {
        var arr = new int[]{7, 7, 7, 7, 7, 7, 7};

        assertThat(new Solution().findLucky(arr)).isEqualTo(7);
    }
}
