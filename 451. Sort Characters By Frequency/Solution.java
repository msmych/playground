import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {
    public String frequencySort(String s) {
        return s.chars()
            .mapToObj(Character::toString)
            .collect(groupingBy(c -> c))
            .values().stream()
            .sorted(comparing(List::size, reverseOrder()))
            .map(list -> String.join("", list))
            .collect(joining());
    }

    // java Solution.java "tree" "eert" "cccaaa" "cccaaa" "Aabb" "bbAa"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().frequencySort(s), expected, s));
        }
    }
}
