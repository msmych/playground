package uk.matvey.play.leet0126.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result = new Solution().findLadders("hit", "cog", wordList);

        assertThat(result).containsExactlyInAnyOrder(List.of("hit", "hot", "dot", "dog", "cog"), List.of("hit", "hot", "lot", "log", "cog"));
    }

    @Test
    public void case2() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log");

        List<List<String>> result = new Solution().findLadders("hit", "cog", wordList);

        assertThat(result).isEmpty();
    }
}
