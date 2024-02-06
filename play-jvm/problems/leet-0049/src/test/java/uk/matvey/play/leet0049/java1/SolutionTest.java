package uk.matvey.play.leet0049.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        var result = new Solution().groupAnagrams(strs);

        assertThat(result).hasSize(3);
    }
}
