package uk.matvey.play.leet0458.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().poorPigs(4, 15, 15);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        int result = new Solution().poorPigs(4, 15, 30);

        assertThat(result).isEqualTo(2);
    }
}
