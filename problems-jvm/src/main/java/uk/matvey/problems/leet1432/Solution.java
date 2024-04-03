package uk.matvey.problems.leet1432;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxDiff(int num) {
        var s = String.valueOf(num);
        var a = s.substring(0, 1);
        var diff = Integer.parseInt(s.replaceAll(a, "9")) - Integer.parseInt(s.replaceAll(a, "1"));
        if (a.equals("1") || a.equals("9")) {
            var b = "";
            for (char c : s.toCharArray()) {
                if (c != s.charAt(0) && (a.equals("1") && c != '0' || a.equals("9") && c != '9')) {
                    b = Character.toString(c);
                    break;
                }
            }
            if (b.isEmpty()) {
                return diff;
            }
            if (a.equals("9")) {
                diff += Integer.parseInt(s.replaceAll(b, "9")) - num;
            } else {
                diff += num - Integer.parseInt(s.replaceAll(b, "0"));
            }
        }
        return diff;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().maxDiff(555)).isEqualTo(888);
    }

    @Test
    void case2() {
        assertThat(new Solution().maxDiff(9)).isEqualTo(8);
    }

    @Test
    void case3() {
        assertThat(new Solution().maxDiff(123456)).isEqualTo(820000);
    }

    @Test
    void case4() {
        assertThat(new Solution().maxDiff(10000)).isEqualTo(80000);
    }

    @Test
    void case5() {
        assertThat(new Solution().maxDiff(9288)).isEqualTo(8700);
    }

    @Test
    void case6() {
        assertThat(new Solution().maxDiff(1101057)).isEqualTo(8808050);
    }
}
