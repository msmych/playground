package uk.matvey.problems.leet0127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var steps = 0;
        var queue = new LinkedList<String>();
        queue.offer(beginWord);
        var wordOptions = new ArrayList<>(wordList);
        while (!wordOptions.isEmpty()) {
            for (var size = queue.size(); size > 0; size--) {
                var word = queue.poll();
                if (word.equals(endWord)) {
                    return steps + 1;
                }
                var nextSet = wordOptions.stream()
                    .filter(w -> isOneLetterDifference(w, word))
                    .collect(Collectors.toSet());
                if (nextSet.isEmpty() && queue.isEmpty()) {
                    return 0;
                }
                wordOptions.removeAll(nextSet);
                for (var next : nextSet) {
                    queue.offer(next);
                }
            }
            steps++;
        }
        return queue.contains(endWord) ? steps + 1 : 0;
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
}

class SolutionTest {

    @Test
    public void case1() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        int result = new Solution().ladderLength("hit", "cog", wordList);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        var wordList = List.of("hot", "dot", "dog", "lot", "log");

        int result = new Solution().ladderLength("hit", "cog", wordList);

        assertThat(result).isEqualTo(0);
    }
}
