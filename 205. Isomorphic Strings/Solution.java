import java.util.*;

class Solution {

    public boolean isIsomorphic(String s, String t) {
        var map = new HashMap<Character, Character>();
        for (var i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (map.containsKey(sc) || map.containsValue(tc)) {
                if (!map.containsKey(sc) || map.get(sc) != tc) {
                    return false;
                }
            } else {
                map.put(sc, tc);
            }
        }
        return true;
    }

    // java Solution.java "egg" "add" "true" "foo" "bar" "false" "paper" "title" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], t = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s",
                new Solution().isIsomorphic(s, t), expected, s, t));
        }
    }
}
