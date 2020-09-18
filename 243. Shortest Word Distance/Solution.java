import java.util.*;

import static java.lang.Math.*;

class Solution {

    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> indexes1 = new ArrayList<>(), indexes2 = new ArrayList<>();
        for (var i = 0; i < words.length; i++) {
            var word = words[i];
            if (word.equals(word1)) {
                indexes1.add(i);
            }
            if (word.equals(word2)) {
                indexes2.add(i);
            }
        }
        var min = words.length;
        for (var i : indexes1) {
            for (var j : indexes2) {
                if (abs(j - i) < min) {
                    min = abs(j - i);
                }
            }
        }
        return min;
    }

    // java Solution.java "[practice,makes,perfect,coding,makes]" "coding" "practice" "3" "[practice,makes,perfect,coding,makes]" "makes" "coding" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String words = args[i], word1 = args[i + 1], word2 = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s, word1 = %s, word2 = %s",
                new Solution().shortestDistance(stringArr(words), word1, word2), expected, words, word1, word2));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
