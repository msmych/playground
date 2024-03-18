package uk.matvey.problems.leet1338;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minSetSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        var occurrences = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)))
            .values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .toList();
        int i = 0;
        for (int sum = 0; sum < arr.length / 2; i++) {
            sum += occurrences.get(i);
        }
        return i;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var arr = new int[]{7, 7, 7, 7, 7, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        var arr = new int[]{1, 9};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var arr = new int[]{1000, 1000, 3, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case5() {
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(5);
    }
}
