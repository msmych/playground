package uk.matvey.play.leet0187.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<String> result = new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        assertThat(result).containsExactly("AAAAACCCCC", "CCCCCAAAAA");
    }

    @Test
    public void case2() {
        List<String> result = new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA");

        assertThat(result).containsExactly("AAAAAAAAAA");
    }
}
