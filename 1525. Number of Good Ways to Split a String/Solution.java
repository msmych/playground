import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public int numSplits(String s) {
        var left = new HashMap<Character, Integer>();
        var right = s.chars().mapToObj(c -> (char) c).collect(groupingBy(c -> c, summingInt(c -> 1)));
        var good = 0;
        for (var c : s.toCharArray()) {
            left.merge(c, 1, Integer::sum);
            if (right.containsKey(c)) {
                if (right.get(c) > 1) {
                    right.merge(c, -1, Integer::sum);
                } else {
                    right.remove(c);
                }
            }
            if (left.keySet().size() > right.keySet().size()) {
                break;
            }
            if (left.keySet().size() == right.keySet().size()) {
                good++;
            }
        }
        return good;
    }

    // java Solution.java "aacaba" "2" "abcd" "1" "aaaaa" "4" "acbadbaada" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().numSplits(s), expected, s));
        }
    }
}
