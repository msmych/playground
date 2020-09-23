import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        var bannedSet = Stream.of(banned).collect(toSet());
        var words = Stream.of(paragraph.split("[ !?',;.]"))
            .filter(word -> !word.isEmpty())
            .map(String::toLowerCase)
            .filter(word -> !bannedSet.contains(word))
            .collect(toList());
        return words.stream()
            .distinct()
            .collect(toMap(w -> w, word -> (int) words.stream().filter(w -> w.equals(word)).count()))
            .entrySet().stream()
            .max(comparingInt(Map.Entry::getValue))
            .get()
            .getKey();
    }

    // java Solution.java "Bob hit a ball, the hit BALL flew far after it was hit." "[hit]" "ball"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String paragraph = args[i], banned = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: paragraph = %s, banned = %s",
                new Solution().mostCommonWord(paragraph, stringArr(banned)), expected, paragraph, banned));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
