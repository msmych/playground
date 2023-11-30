package uk.matvey.play.leet1291.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().sequentialDigits(100, 300);

        assertThat(result).containsExactly(123, 234);
    }

    @Test
    public void case2() {
        List<Integer> result = new Solution().sequentialDigits(1000, 13000);

        assertThat(result).containsExactly(1234, 2345, 3456, 4567, 5678, 6789, 12345);
    }
}
