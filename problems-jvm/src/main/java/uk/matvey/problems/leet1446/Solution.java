package uk.matvey.problems.leet1446;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxPower(String s) {
        var max = 0;
        Optional<Character> last = Optional.empty();
        var power = 0;
        for (char c : s.toCharArray()) {
            if (last.isEmpty() || last.get() != c) {
                power = 1;
                last = Optional.of(c);
            } else {
                power++;
            }
            if (power > max) {
                max = power;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().maxPower("leetcode")).isEqualTo(2);
    }

    @Test
    void case2() {
        assertThat(new Solution().maxPower("abbcccddddeeeeedcba")).isEqualTo(5);
    }

    @Test
    void case3() {
        assertThat(new Solution().maxPower("triplepillooooow")).isEqualTo(5);
    }

    @Test
    void case4() {
        assertThat(new Solution().maxPower("hooraaaaaaaaaaay")).isEqualTo(11);
    }

    @Test
    void case5() {
        assertThat(new Solution().maxPower("tourist")).isEqualTo(1);
    }
}