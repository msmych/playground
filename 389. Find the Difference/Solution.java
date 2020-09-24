import java.util.*;

class Solution {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sMap = occurrences(s), tMap = occurrences(t);
        for (var tEntry : tMap.entrySet()) {
            var c = tEntry.getKey();
            if (!sMap.containsKey(c) || sMap.get(c) != tEntry.getValue()) {
                return c;
            }
        }
        throw new IllegalArgumentException();
    }

    private Map<Character, Integer> occurrences(String s) {
        var occurrences = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            occurrences.merge(c, 1, Integer::sum);
        }
        return occurrences;
    }

    // java Solution.java "abcd" "abcde" "e"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], t = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s",
                new Solution().findTheDifference(s, t), expected, s, t));
        }
    }
}
