package uk.matvey.play.leet2896.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var s1 = "1100011000";
        var s2 = "0101001010";

        int result = new Solution().minOperations(s1, s2, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var s1 = "10110";
        var s2 = "00011";

        int result = new Solution().minOperations(s1, s2, 4);

        assertThat(result).isEqualTo(-1);
    }
}
