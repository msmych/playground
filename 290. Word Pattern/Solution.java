import java.util.*;

class Solution {

    public boolean wordPattern(String pattern, String str) {
        var words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        var map = new HashMap<Character, String>();
        for (var i = 0; i < pattern.toCharArray().length; i++) {
            var c = pattern.charAt(i);
            var word = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (map.values().stream().anyMatch(word::equals)) {
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;
    }

    // java Solution.java "abba" "dog cat cat dog" "true" "abba" "dog cat cat fish" "false" "aaaa" "dog cat cat dog" "false" "abba" "dog dog dog dog" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String pattern = args[i], str = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: pattern = %s, str = %s",
                new Solution().wordPattern(pattern, str), expected, pattern, str));
        }
    }
}
