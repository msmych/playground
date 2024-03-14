package uk.matvey.problems.leet0012;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String intToRoman(int num) {
        var sb = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                sb.append('M');
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append('D');
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append('C');
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append('L');
                num -= 50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                sb.append('X');
                num -= 10;
            } else if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append('V');
                num -= 5;
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append('I');
                num -= 1;
            }
        }
        return sb.toString();
    }
}

class SolutionTest {

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
