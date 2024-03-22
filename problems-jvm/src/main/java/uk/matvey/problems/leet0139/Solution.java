package uk.matvey.problems.leet0139;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final Map<String, Boolean> cache = new HashMap<>();
    private final Set<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return nextBreak(s);
    }

    private boolean nextBreak(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (dict.contains(s)) {
            return true;
        }
        var breaks = dict.stream()
            .filter(s::startsWith)
            .map(String::length)
            .map(s::substring)
            .anyMatch(this::nextBreak);
        cache.put(s, breaks);
        return breaks;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var wordDict = List.of("leet", "code");

        assertThat(new Solution().wordBreak("leetcode", wordDict)).isTrue();
    }

    @Test
    void case2() {
        var wordDict = List.of("apple","pen");

        assertThat(new Solution().wordBreak("applepenapple", wordDict)).isTrue();
    }

    @Test
    void case3() {
        var wordDict = List.of("cats","dog","sand","and","cat");

        assertThat(new Solution().wordBreak("catsandog", wordDict)).isFalse();
    }
}
