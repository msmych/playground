import java.util.List;

import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

class Solution {
    public List<String> stringMatching(String[] words) {
        return stream(words)
            .filter(word -> stream(words).filter(not(word::equals)).anyMatch(w -> w.contains(word)))
            .collect(toList());
    }

    // java Solution.java "[mass,as,hero,superhero]" "[as,hero]" "[leetcode,et,code]" "[et,code]" "[blue,green,bu]" "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String words = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s",
                new Solution().stringMatching(array(words)), expected, words));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
