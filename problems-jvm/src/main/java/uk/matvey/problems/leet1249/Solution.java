package uk.matvey.problems.leet1249;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public String minRemoveToMakeValid(String s) {
        var sb = new StringBuilder(s);
        var stack = new Stack<Integer>();
        for (int i = 0; i < sb.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i + 1);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(-1 - i);
                } else {
                    stack.pop();
                }
            }
        }
        var valid = new StringBuilder();
        for (int i = 0, j = 0; i < sb.length(); i++) {
            if (j >= stack.size() || i != Math.abs(stack.elementAt(j)) - 1) {
                valid.append(sb.charAt(i));
            } else {
                j++;
            }
        }
        return valid.toString();
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().minRemoveToMakeValid("lee(t(c)o)de)")).isEqualTo("lee(t(c)o)de");
    }

    @Test
    void case2() {
        assertThat(new Solution().minRemoveToMakeValid("a)b(c)d")).isEqualTo("ab(c)d");
    }

    @Test
    void case3() {
        assertThat(new Solution().minRemoveToMakeValid("))((")).isEqualTo("");
    }
}