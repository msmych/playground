package uk.matvey.play.leet0779.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().kthGrammar(1, 1);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case2() {
        int result = new Solution().kthGrammar(2, 1);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().kthGrammar(2, 2);

        assertThat(result).isEqualTo(1);
    }
}
