package uk.matvey.play.leet0150.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var tokens = new String[]{"2", "1", "+", "3", "*"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(9);
    }

    @Test
    public void case2() {
        var tokens = new String[]{"4", "13", "5", "/", "+"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case3() {
        var tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(22);
    }
}
