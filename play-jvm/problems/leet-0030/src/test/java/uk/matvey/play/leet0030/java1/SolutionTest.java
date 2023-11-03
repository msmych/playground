package uk.matvey.play.leet0030.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var words = new String[]{"foo", "bar"};

        List<Integer> result = new Solution().findSubstring("barfoothefoobarman", words);

        assertThat(result).containsExactly(0, 9);
    }

    @Test
    public void case2() {
        var words = new String[]{"word","good","best","word"};

        List<Integer> result = new Solution().findSubstring("wordgoodgoodgoodbestword", words);

        assertThat(result).isEmpty();
    }

    @Test
    public void case3() {
        var words = new String[]{"bar","foo","the"};

        List<Integer> result = new Solution().findSubstring("barfoofoobarthefoobarman", words);

        assertThat(result).containsExactly(6, 9, 12);
    }
}
