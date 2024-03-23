package uk.matvey.problems.leet1400;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        return s.chars().boxed()
            .collect(Collectors.groupingBy(c -> c,
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
            .values().stream()
            .filter(n -> n % 2 == 1)
            .count() <= k;
    }
}

class SolutionTest {

    @Test
    void case1() {
        final var result = new Solution().canConstruct("annabelle", 2);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        final var result = new Solution().canConstruct("leetcode", 3);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        final var result = new Solution().canConstruct("true", 4);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        final var result = new Solution().canConstruct("yzyzyzyzyzyzyzy", 2);

        assertThat(result).isTrue();
    }

    @Test
    void case5() {
        final var result = new Solution().canConstruct("cr", 7);

        assertThat(result).isFalse();
    }
}