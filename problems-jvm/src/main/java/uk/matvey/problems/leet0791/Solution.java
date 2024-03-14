package uk.matvey.problems.leet0791;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String customSortString(String order, String s) {
        return s.chars()
            .boxed()
            .sorted(Comparator.comparingInt(order::indexOf))
            .map(Character::toString)
            .collect(Collectors.joining());
    }
}

class SolutionTest {

    @Test
    void case1() {
        var result = new Solution().customSortString("cba", "abcd");

        assertThat(result).contains("cba");
    }

    @Test
    void case2() {
        var result = new Solution().customSortString("bcafg", "abcd");

        assertThat(result).contains("bca");
    }
}
