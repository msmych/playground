import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {

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
        var arranged = map.entrySet().stream()
            .sorted(comparingInt(Map.Entry::getKey))
            .flatMap(e -> e.getValue().stream()
                .sorted(comparingInt(wordWithIndex -> wordWithIndex.i))
                .map(wordWithIndex -> wordWithIndex.word))
            .collect(toList());
        arranged.set(0, arranged.get(0).substring(0, 1).toUpperCase() + arranged.get(0).substring(1));
        return String.join(" ", arranged);
    }

    // java Solution.java "Leetcode is cool" "Is cool leetcode" "Keep calm and code on" "On and keep calm code" "To be or not to be" "To be or to be not"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String text = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text = %s",
                new Solution().arrangeWords(text), expected, text));
        }
    }
}
