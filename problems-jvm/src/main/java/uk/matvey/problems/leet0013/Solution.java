package uk.matvey.problems.leet0013;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        final int value;

        Roman(int value) {
            this.value = value;
        }
    }

    private enum UncommonRoman {
        IV(4),
        IX(9),
        XL(40),
        XC(90),
        CD(400),
        CM(900);

        final int value;

        UncommonRoman(int value) {
            this.value = value;
        }
    }

    public int romanToInt(String s) {
        var result = 0;
        var uncommonRomans = UncommonRoman.values();
        for (var uncommonRoman : uncommonRomans) {
            if (s.contains(uncommonRoman.name())) {
                s = s.replace(uncommonRoman.name(), "");
                result = result + uncommonRoman.value;
            }
        }
        for (var i = 0; i < s.length(); i++) {
            var roman = Roman.valueOf(String.valueOf(s.charAt(i)));
            var value = roman.value;
            result = result + value;
        }

        return result;
    }
}

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
