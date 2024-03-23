package uk.matvey.problems.leet0140;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final List<String> dict = new ArrayList<>();
    private final Map<String, Set<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return new ArrayList<>(nextBreak(s));
    }

    private Set<String> nextBreak(String s) {
        if (s.isEmpty()) {
            return new HashSet<>();
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var phrases = dict.stream().filter(s::equals).collect(Collectors.toSet());
        for (var word : dict.stream().filter(w -> !w.equals(s)).filter(s::startsWith).collect(Collectors.toSet())) {
            for (var nextPhrase : nextBreak(s.substring(word.length()))) {
                phrases.add(word + " " + nextPhrase);
            }
        }
        cache.put(s, phrases);
        return phrases;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var wordDict = List.of("cat", "cats", "and", "sand", "dog");

        List<String> result = new Solution().wordBreak("catsanddog", wordDict);

        assertThat(result).containsExactlyInAnyOrder("cats and dog", "cat sand dog");
    }

    @Test
    void case2() {
        var wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");

        List<String> result = new Solution().wordBreak("pineapplepenapple", wordDict);

        assertThat(result).containsExactlyInAnyOrder("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
    }

    @Test
    void case3() {
        var wordDict = List.of("cats","dog","sand","and","cat");

        List<String> result = new Solution().wordBreak("catsandog", wordDict);

        assertThat(result).containsExactlyInAnyOrder();
    }
}