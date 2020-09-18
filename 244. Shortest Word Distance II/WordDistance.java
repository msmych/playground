import java.util.*;

import static java.lang.Math.*;

class WordDistance {

    private final Map<String, List<Integer>> indexes = new HashMap<>();

    public WordDistance(String[] words) {
        for (var i = 0; i < words.length; i++) {
            indexes.putIfAbsent(words[i], new ArrayList<>());
            indexes.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        var min = Integer.MAX_VALUE;
        for (var i : indexes.get(word1)) {
            for (var j : indexes.get(word2)) {
                if (abs(j - i) < min) {
                    min = abs(j - i);
                }
            }
        }
        return min;
    }

    public static void main(String... args) {
        var dist = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(String.format("Output: %s | Expected: %s | Input: word1 = %s, word2 = %s", dist.shortest("coding", "practice"), 3, "coding", "practice"));
        System.out.println(String.format("Output: %s | Expected: %s | Input: word1 = %s, word2 = %s", dist.shortest("makes", "coding"), 1, "makes", "coding"));
    }
}
