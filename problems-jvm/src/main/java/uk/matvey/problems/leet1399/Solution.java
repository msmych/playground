package uk.matvey.problems.leet1399;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int countLargestGroup(int n) {
        var sums = IntStream.rangeClosed(1, n)
            .boxed()
            .collect(Collectors.groupingBy(this::sumOfDigits,
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
            .values();
        var max = sums.stream().mapToInt(v -> v).max().orElse(0);
        return (int) sums.stream().filter(v -> v == max).count();
    }

    private int sumOfDigits(int n) {
        return String.valueOf(n).chars()
            .map(c -> c - '0')
            .sum();
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().countLargestGroup(13)).isEqualTo(4);
    }

    @Test
    void case2() {
        assertThat(new Solution().countLargestGroup(2)).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().countLargestGroup(15)).isEqualTo(6);
    }

    @Test
    void case4() {
        assertThat(new Solution().countLargestGroup(24)).isEqualTo(5);
    }
}
