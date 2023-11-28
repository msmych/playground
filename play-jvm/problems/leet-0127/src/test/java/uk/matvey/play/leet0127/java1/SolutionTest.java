package uk.matvey.play.leet0127.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        int result = new Solution().ladderLength("hit", "cog", wordList);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log");

        int result = new Solution().ladderLength("hit", "cog", wordList);

        assertThat(result).isEqualTo(0);
    }
}
