package uk.matvey.play.leet0013.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().romanToInt("III");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().romanToInt("IV");

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        int result = new Solution().romanToInt("IX");

        assertThat(result).isEqualTo(9);
    }

    @Test
    public void case4() {
        int result = new Solution().romanToInt("LVIII");

        assertThat(result).isEqualTo(58);
    }

    @Test
    public void case5() {
        int result = new Solution().romanToInt("MCMXCIV");

        assertThat(result).isEqualTo(1994);
    }
}
