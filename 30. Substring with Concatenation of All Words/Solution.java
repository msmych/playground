import java.util.*;

import static java.util.Collections.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private final Map<Integer, String> cache = new HashMap<>();

    private String s;
    private Map<String, Integer> wordMap;
    private int wordCount;
    private int wordLength;

    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        if (words.length == 0) {
            return emptyList();
        }
        wordMap = stream(words)
            .collect(groupingBy(word -> word, summingInt(word -> 1)));
        wordCount = words.length;
        wordLength = words[0].length();
        var starting = new ArrayList<Integer>();
        for (var i = 0; i <= s.length() - wordCount * wordLength; i++) {
            if (isConcatenation(i)) {
                starting.add(i);
            }
        }
        return starting;
    }

    private boolean isConcatenation(int i) {
        var map = new HashMap<String, Integer>(wordMap);
        for (var j = i; j < i + wordCount * wordLength; j += wordLength) {
            String word;
            if (cache.containsKey(j)) {
                word = cache.get(j);
            } else {
                word = s.substring(j, j + wordLength);
                cache.put(j, word);
            }
            if (!map.containsKey(word) || map.get(word) < 1) {
                return false;
            } else {
                map.merge(word, -1, Integer::sum);
            }
        }
        return true;
    }

    // java Solution.java "barfoothefoobarman" "[foo,bar]" "[0,9]" "wordgoodgoodgoodbestword" "[word,good,best,word]" "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], words = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, words = %s",
                new Solution().findSubstring(s, array(words)), expected, s, words));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
