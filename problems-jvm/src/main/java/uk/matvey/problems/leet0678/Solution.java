package uk.matvey.problems.leet0678;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean checkValidString(String s) {
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                n++;
            } else {
                n--;
            }
            if (n < 0) {
                return false;
            }
        }
        n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                n++;
            } else {
                n--;
            }
            if (n < 0) {
                return false;
            }
        }
        return true;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().checkValidString("()")).isTrue();
    }

    @Test
    void case2() {
        assertThat(new Solution().checkValidString("(*)")).isTrue();
    }

    @Test
    void case3() {
        assertThat(new Solution().checkValidString("(*))")).isTrue();
    }

    @Test
    void case4() {
        assertThat(new Solution().checkValidString("**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))")).isTrue();
    }
}