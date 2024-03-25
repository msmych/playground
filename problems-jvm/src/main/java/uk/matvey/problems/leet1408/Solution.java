package uk.matvey.problems.leet1408;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<String> stringMatching(String[] words) {
        return Arrays.stream(words)
            .filter(word ->
                Arrays.stream(words)
                    .filter(Predicate.not(word::equals))
                    .anyMatch(w -> w.contains(word))
            )
            .toList();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var words = new String[]{"mass", "as", "hero", "superhero"};

        var result = new Solution().stringMatching(words);

        assertThat(result).containsExactly("as", "hero");
    }

    @Test
    void case2() {
        var words = new String[]{"leetcode", "et", "code"};

        var result = new Solution().stringMatching(words);

        assertThat(result).containsExactly("et", "code");
    }

    @Test
    void case3() {
        var words = new String[]{"blue", "green", "bu"};

        var result = new Solution().stringMatching(words);

        assertThat(result).containsExactly();
    }
}
