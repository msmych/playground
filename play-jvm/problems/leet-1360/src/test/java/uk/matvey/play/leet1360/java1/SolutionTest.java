package uk.matvey.play.leet1360.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().daysBetweenDates("2019-06-29", "2019-06-30")).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().daysBetweenDates("2020-01-15", "2019-12-31")).isEqualTo(15);
    }
}
