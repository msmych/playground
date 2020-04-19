import java.util.List;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.partitioningBy;

class Solution {
    public String reformat(String s) {
        var split = s.chars()
            .mapToObj(c -> (char) c)
            .collect(partitioningBy(c -> c >= '0' && c <= '9'));
        List<Character> longer;
        List<Character> shorter;
        if (abs(split.get(true).size() - split.get(false).size()) > 1) {
            return "";
        }
        if (split.get(true).size() > split.get(false).size()) {
            longer = split.get(true);
            shorter = split.get(false);
        } else {
            longer = split.get(false);
            shorter = split.get(true);
        }
        var sb = new StringBuilder();
        for (var i = 0; i < shorter.size(); i++) {
            sb.append(longer.get(i));
            sb.append(shorter.get(i));
        }
        if (longer.size() > shorter.size()) {
            sb.append(longer.get(longer.size() - 1));
        }
        return sb.toString();
    }

    // java Solution.java "a0b1c2" "0a1b2c" "leetcode" "" "1229857369" "" "covid2019" "c2o0v1i9d" "ab123" "1a2b3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().reformat(s), expected, s));
        }
    }
}
