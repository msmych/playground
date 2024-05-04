package uk.matvey.problems.leet1451;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static class WordWithIndex {
        String word;
        int i;

        WordWithIndex(String word, int i) {
            this.word = word;
            this.i = i;
        }
    }

    public String arrangeWords(String text) {
        var words = text.split(" ");
        var map = new HashMap<Integer, List<WordWithIndex>>();
        for (var i = 0; i < words.length; i++) {
            if (map.containsKey(words[i].length())) {
                map.get(words[i].length()).add(new WordWithIndex(words[i].toLowerCase(), i));
            } else {
                var wordWithIndex = new ArrayList<WordWithIndex>();
                wordWithIndex.add(new WordWithIndex(words[i].toLowerCase(), i));
                map.put(words[i].length(), wordWithIndex);
            }
        }
        var arranged = new ArrayList<>(map.entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getKey))
            .flatMap(e -> e.getValue().stream()
                .sorted(Comparator.comparingInt(wordWithIndex -> wordWithIndex.i))
                .map(wordWithIndex -> wordWithIndex.word))
            .toList());
        arranged.set(0, arranged.getFirst().substring(0, 1).toUpperCase() + arranged.getFirst().substring(1));
        return String.join(" ", arranged);
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().arrangeWords("Leetcode is cool")).isEqualTo("Is cool leetcode");
    }

    @Test
    void case2() {
        assertThat(new Solution().arrangeWords("Keep calm and code on")).isEqualTo("On and keep calm code");
    }

    @Test
    void case3() {
        assertThat(new Solution().arrangeWords("To be or not to be")).isEqualTo("To be or to be not");
    }
}