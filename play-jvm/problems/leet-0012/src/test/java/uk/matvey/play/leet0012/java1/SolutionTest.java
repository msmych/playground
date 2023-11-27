package uk.matvey.play.leet0012.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().intToRoman(3);

        assertThat(result).isEqualTo("III");
    }

    @Test
    public void case2() {
        String result = new Solution().intToRoman(4);

        assertThat(result).isEqualTo("IV");
    }

    @Test
    public void case3() {
        String result = new Solution().intToRoman(9);

        assertThat(result).isEqualTo("IX");
    }

    @Test
    public void case4() {
        String result = new Solution().intToRoman(58);

        assertThat(result).isEqualTo("LVIII");
    }

    @Test
    public void case5() {
        String result = new Solution().intToRoman(1994);

        assertThat(result).isEqualTo("MCMXCIV");
    }
}
