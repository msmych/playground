import java.util.*;

class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return getMap(s).equals(getMap(t));
    }

    private Map<Character, Integer> getMap(String s) {
        var map = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    // java Solution.java "anagram" "nagaram" "true" "rat" "car" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], t = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s",
                new Solution().isAnagram(s, t), expected, s, t));
        }
    }
}
