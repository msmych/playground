package uk.matvey.problems.leet0402;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String removeKdigits(String num, int k) {
        var stack = new Stack<Character>();
        Optional<Character> last = Optional.empty();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            if (i < num.length() - 1) {
                stack.push(num.charAt(i));
            } else {
                last = Optional.of(num.charAt(i));
            }
        }
        while (k-- > 0) {
            if (last.isPresent()) {
                if (stack.isEmpty() || last.get() > stack.peek()) {
                    last = Optional.empty();
                } else {
                    stack.pop();
                }
            } else {
                stack.pop();
            }
        }
        last.ifPresent(stack::push);
        var s = stack.stream()
            .dropWhile(c -> c == '0')
            .map(Object::toString)
            .collect(Collectors.joining());
        return s.isEmpty() ? "0" : s;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().removeKdigits("1432219", 3)).isEqualTo("1219");
    }

    @Test
    void case2() {
        assertThat(new Solution().removeKdigits("10200", 1)).isEqualTo("200");
    }

    @Test
    void case3() {
        assertThat(new Solution().removeKdigits("10", 2)).isEqualTo("0");
    }

    @Test
    void case4() {
        assertThat(new Solution().removeKdigits("9", 1)).isEqualTo("0");
    }

    @Test
    void case5() {
        assertThat(new Solution().removeKdigits("1234567890", 9)).isEqualTo("0");
    }
}
