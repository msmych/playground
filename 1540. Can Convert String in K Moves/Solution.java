import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

class Solution {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        var differences = range(0, s.length()).map(i -> (t.charAt(i) + 26 - s.charAt(i)) % 26).filter(diff -> diff != 0).boxed().collect(toList());
        var used = new HashSet<Integer>();
        for (var diff : differences) {
            var shift = false;
            for (var i = diff > 0 ? diff : 26 - diff; i <= k; i += 26) {
                if (!used.contains(i)) {
                    used.add(i);
                    shift = true;
                    break;
                }
            }
            if (!shift) {
                return false;
            }
        }
        return true;
    }

    // java Solution.java "input" "ouput" "9" "true" "abc" "bcd" "10" "false" "aab" "bbb" "27" "true" abc abcd 1000 false "atmtxzjkz" "tvbtjhvjd" 35 false "mpzzwh" "kaeblv" 24 true


    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String s = args[i], t = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s, k = %s",
                new Solution().canConvertString(s, t, Integer.parseInt(k)), expected, s, t, k));
        }
    }
}
