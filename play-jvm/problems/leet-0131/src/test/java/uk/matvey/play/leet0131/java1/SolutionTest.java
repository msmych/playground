package uk.matvey.play.leet0131.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<List<String>> result = new Solution().partition("aab");

        assertThat(result).containsExactlyInAnyOrder(List.of("aa", "b"), List.of("a", "a", "b"));
    }
}
