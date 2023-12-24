package uk.matvey.play.leet1366.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ACB");
    }

    @Test
    public void case2() {
        var votes = new String[]{"WXYZ", "XYZW"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("XWYZ");
    }

    @Test
    public void case3() {
        var votes = new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ZMNAGUEDSJYLBOPHRQICWFXTVK");
    }

    @Test
    public void case4() {
        var votes = new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ABC");
    }

    @Test
    public void case5() {
        var votes = new String[]{"M", "M", "M", "M"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("M");
    }
}
