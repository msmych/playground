import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        return new ArrayList<>(stream(strings).collect(groupingBy(this::normalize)).values());
    }

    private String normalize(String s) {
        var diff = 26 - (s.charAt(0) - 'a');
        return s.chars().map(c -> (char) (c + diff) % 26).mapToObj(Character::toString).collect(joining());
    }

    // java Solution.java "[abc,bcd,acef,xyz,az,ba,a,z]" "[[abc,bcd,xyz],[az,ba],[acef],[a,z]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String strings = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: strings = %s",
                new Solution().groupStrings(stringArr(strings)), expected, strings));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
