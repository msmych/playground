package uk.matvey.problems.leet0242;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return getMap(s).equals(getMap(t));
    }

    private Map<Character, Integer> getMap(String s) {
        var map = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isAnagram("anagram", "nagaram");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isAnagram("rat", "car");

        assertThat(result).isFalse();
    }
}
