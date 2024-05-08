package uk.matvey.problems.leet1455;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        var words = sentence.split(" ");
        return IntStream.range(0, words.length)
            .filter(i -> words[i].startsWith(searchWord))
            .map(i -> i + 1)
            .findFirst()
            .orElse(-1);
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().isPrefixOfWord("i love eating burger", "burg")).isEqualTo(4);
    }

    @Test
    void case2() {
        assertThat(new Solution().isPrefixOfWord("this problem is an easy problem", "pro")).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().isPrefixOfWord("i am tired", "you")).isEqualTo(-1);
    }

    @Test
    void case4() {
        assertThat(new Solution().isPrefixOfWord("i use triple pillow", "pill")).isEqualTo(4);
    }

    @Test
    void case5() {
        assertThat(new Solution().isPrefixOfWord("hello from the other side", "they")).isEqualTo(-1);
    }
}
