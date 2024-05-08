package uk.matvey.problems.leet1460;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        return occurrences(target).equals(occurrences(arr));
    }

    private Map<Integer, Integer> occurrences(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)));
    }
}

class SolutionTest {

    @Test
    void case1() {
        var target = new int[]{1, 2, 3, 4};
        var arr = new int[]{2, 4, 1, 3};

        var result = new Solution().canBeEqual(target, arr);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        var target = new int[]{7};
        var arr = new int[]{7};

        var result = new Solution().canBeEqual(target, arr);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        var target = new int[]{1, 12};
        var arr = new int[]{12, 1};

        var result = new Solution().canBeEqual(target, arr);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        var target = new int[]{3, 7, 9};
        var arr = new int[]{3, 7, 11};

        var result = new Solution().canBeEqual(target, arr);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        var target = new int[]{1, 1, 1, 1, 1};
        var arr = new int[]{1, 1, 1, 1, 1};

        var result = new Solution().canBeEqual(target, arr);

        assertThat(result).isTrue();
    }
}
