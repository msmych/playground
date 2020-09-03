import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        var map = new HashMap<String, Integer>();
        for (var i = 0; i <= s.length() - 10; i++) {
            var chunk = s.substring(i, i + 10);
            map.put(chunk, map.getOrDefault(chunk, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    // java Solution.java "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" "[AAAAACCCCC,CCCCCAAAAA]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().findRepeatedDnaSequences(s), expected, s));
        }
    }
}
