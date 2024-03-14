package uk.matvey.problems.leet0126;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final Queue<List<String>> queue = new LinkedList<>();

    private String endWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.endWord = endWord;
        queue.offer(List.of(beginWord));
        var wordOptions = new ArrayList<>(wordList);
        var allNextWords = new HashSet<String>();
        while (!wordOptions.isEmpty()) {
            if (queue.stream().anyMatch(list -> list.get(list.size() - 1).equals(endWord))) {
                return relevantLadders();
            }
            for (var size = queue.size(); size > 0; size--) {
                var words = queue.poll();
                var nextSet = wordOptions.stream()
                    .filter(word -> isOneLetterDifference(word, words.get(words.size() - 1)))
                    .collect(Collectors.toSet());
                allNextWords.addAll(nextSet);
                for (String next : nextSet) {
                    var list = new ArrayList<>(words);
                    list.add(next);
                    queue.offer(list);
                }
            }
            if (allNextWords.isEmpty()) {
                return new ArrayList<>();
            }
            wordOptions.removeAll(allNextWords);
        }
        if (queue.stream().noneMatch(words -> words.get(words.size() - 1).equals(endWord))) {
            return new ArrayList<>();
        }
        return relevantLadders();
    }

    private boolean isOneLetterDifference(String w1, String w2) {
        var diff = 0;
        for (var i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    private List<List<String>> relevantLadders() {
        return queue.stream()
            .filter(list -> list.get(list.size() - 1).equals(endWord))
            .collect(Collectors.toList());
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result = new Solution().findLadders("hit", "cog", wordList);

        assertThat(result).containsExactlyInAnyOrder(List.of("hit", "hot", "dot", "dog", "cog"), List.of("hit", "hot", "lot", "log", "cog"));
    }

    @Test
    public void case2() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log");

        List<List<String>> result = new Solution().findLadders("hit", "cog", wordList);

        assertThat(result).isEmpty();
    }
}
