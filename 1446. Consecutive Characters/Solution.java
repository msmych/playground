import java.util.*;

import static java.util.Optional.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int maxPower(String s) {
        var max = 0;
        Optional<Character> last = empty();
        var power = 0;
        for (var c : s.toCharArray()) {
            if (last.isEmpty() || last.get() != c) {
                power = 1;
                last = Optional.of(c);
            } else {
                power++;
            }
            if (power > max) {
                max = power;
            }
        }
        return max;
    }

    // java Solution.java "leetcode" "2" "abbcccddddeeeeedcba" "5" "triplepillooooow" "5" "hooraaaaaaaaaaay" "11" "tourist" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().maxPower(s), expected, s));
        }
    }
}
