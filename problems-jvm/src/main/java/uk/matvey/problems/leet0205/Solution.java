package uk.matvey.problems.leet0205;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        var map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc) || map.containsValue(tc)) {
                if (!map.containsKey(sc) || map.get(sc) != tc) {
                    return false;
                }
            } else {
                map.put(sc, tc);
            }
        }
        return true;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().isIsomorphic("egg", "add")).isTrue();
    }

    @Test
    void case2() {
        assertThat(new Solution().isIsomorphic("foo", "bar")).isFalse();
    }

    @Test
    void case3() {
        assertThat(new Solution().isIsomorphic("paper", "title")).isTrue();
    }
}
