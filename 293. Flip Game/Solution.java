import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<String> generatePossibleNextMoves(String s) {
        return range(0, s.length() - 1)
            .filter(i -> s.substring(i, i + 2).equals("++"))
            .mapToObj(i -> s.substring(0, i) + "--" + s.substring(i + 2))
            .collect(toUnmodifiableList());
    }

    // java Solution.java "++++" "[--++,+--+,++--]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().generatePossibleNextMoves(s), expected, s));
        }
    }
}
