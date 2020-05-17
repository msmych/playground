import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.Collections.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty() || p.length() > s.length()) {
            return emptyList();
        }
        var pmap = occurrences(p);
        var smap = occurrences(s.substring(0, p.length()));
        var anagrams = new ArrayList<Integer>();
        if (smap.equals(pmap)) {
            anagrams.add(0);
        }
        for (var i = 0; i + p.length() < s.length(); i++) {
            if (smap.get(s.charAt(i)) == 1) {
                smap.remove(s.charAt(i));
            } else {
                smap.merge(s.charAt(i), -1, Integer::sum);
            }
            smap.merge(s.charAt(i + p.length()), 1, Integer::sum);
            if (smap.equals(pmap)) {
                anagrams.add(i + 1);
            }
        }
        return anagrams;
    }

    private Map<Character, Integer> occurrences(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(c -> c, summingInt(c -> 1)));
    }

    // java Solution.java "cbaebabacd" "abc" "[0, 6]" "abab" "ab" "[0, 1, 2]" "" a "[]" aaaaaaaaaa aaaaaaaaaaaaa "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], p = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, p = %s",
                new Solution().findAnagrams(s, p), expected, s, p));
        }
    }
}
