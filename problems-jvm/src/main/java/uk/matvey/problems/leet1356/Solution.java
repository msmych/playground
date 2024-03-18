package uk.matvey.problems.leet1356;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .sorted(
                Comparator.comparing(n -> Integer.toBinaryString((Integer) n).chars().filter(c -> c == '1').count())
                    .thenComparing(n -> (Integer) n)
            )
            .mapToInt(n -> n)
            .toArray();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

        int[] result = new Solution().sortByBits(arr);

        assertThat(result).containsExactly(0, 1, 2, 4, 8, 3, 5, 6, 7);
    }

    @Test
    public void case2() {
        var arr = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

        int[] result = new Solution().sortByBits(arr);

        assertThat(result).containsExactly(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    }
}
