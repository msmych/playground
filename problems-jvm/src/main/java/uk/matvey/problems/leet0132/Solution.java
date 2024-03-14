package uk.matvey.problems.leet0132;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final Map<String, Boolean> cache = new HashMap<>();
    private final Map<String, Integer> minCache = new HashMap<>();

    public int minCut(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (minCache.containsKey(s)) {
            return minCache.get(s);
        }
        if (isPalindrome(s)) {
            return 0;
        }
        for (var i = 1; i < s.length() - 1; i++) {
            if (isPalindrome(s.substring(0, i)) && isPalindrome(s.substring(i))) {
                return 1;
            }
        }
        int minCut = 1 + IntStream.range(1, s.length())
            .mapToObj(i -> s.substring(0, i))
            .filter(this::isPalindrome)
            .map(String::length)
            .map(s::substring)
            .mapToInt(this::minCut)
            .min()
            .getAsInt();
        minCache.put(s, minCut);
        return minCut;
    }

    private boolean isPalindrome(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var isPalindrome = new StringBuffer(s).reverse().toString().equals(s);
        cache.put(s, isPalindrome);
        return isPalindrome;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minCut("aab");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        int result = new Solution().minCut("a");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().minCut("ab");

        assertThat(result).isEqualTo(1);
    }
}
