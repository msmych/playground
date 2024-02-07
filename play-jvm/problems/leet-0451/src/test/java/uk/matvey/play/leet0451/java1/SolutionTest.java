package uk.matvey.play.leet0451.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().frequencySort("tree");

        assertThat(result).isEqualTo("eert");
    }

    @Test
    public void case2() {
        String result = new Solution().frequencySort("cccaaa");

        assertThat(result).isEqualTo("aaaccc");
    }

    @Test
    public void case3() {
        String result = new Solution().frequencySort("Aabb");

        assertThat(result).isEqualTo("bbaA");
    }
}
