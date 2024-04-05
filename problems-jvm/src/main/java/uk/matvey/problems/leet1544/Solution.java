package uk.matvey.problems.leet1544;

import java.util.Stack;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String makeGood(String s) {
        var stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                var last = stack.peek();
                if (Character.toLowerCase(last) == Character.toLowerCase(c) &&
                    Character.isLowerCase(last) ^ Character.isLowerCase(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().makeGood("leEeetcode")).isEqualTo("leetcode");
    }

    @Test
    void case2() {
        assertThat(new Solution().makeGood("abBAcC")).isEqualTo("");
    }

    @Test
    void case3() {
        assertThat(new Solution().makeGood("s")).isEqualTo("s");
    }
}