import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(stream(strs)
            .collect(groupingBy(this::occurrences))
            .values());
    }

    private Map<Character, Integer> occurrences(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(c -> c, summingInt(c -> 1)));
    }

    // java Solution.java "[eat,tea,tan,ate,nat,bat]" "[[ate,eat,tea],[nat,tan],[bat]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String strs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: strs = %s",
                new Solution().groupAnagrams(array(strs)), expected, strs));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
