package uk.matvey.problems.leet1415;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String getHappyString(int n, int k) {
        return happy('0', n).stream()
            .skip(k - 1)
            .findFirst()
            .orElse("");
    }

    private List<String> happy(char last, int n) {
        if (n == 1) {
            return Stream.of("a", "b", "c")
                .filter(c -> c.indexOf(last) == -1)
                .collect(Collectors.toList());
        }
        var happy = new ArrayList<String>();
        if (last != 'a') {
            for (var a : happy('a', n - 1)) {
                happy.add('a' + a);
            }
        }
        if (last != 'b') {
            for (var b : happy('b', n - 1)) {
                happy.add('b' + b);
            }
        }
        if (last != 'c') {
            for (var c : happy('c', n - 1)) {
                happy.add('c' + c);
            }
        }
        return happy;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().getHappyString(1, 3)).isEqualTo("c");
    }

    @Test
    void case2() {
        assertThat(new Solution().getHappyString(1, 4)).isEqualTo("");
    }

    @Test
    void case3() {
        assertThat(new Solution().getHappyString(3, 9)).isEqualTo("cab");
    }

    @Test
    void case4() {
        assertThat(new Solution().getHappyString(2, 7)).isEqualTo("");
    }

    @Test
    void case5() {
        assertThat(new Solution().getHappyString(10, 100)).isEqualTo("abacbabacb");
    }
}
