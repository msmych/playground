import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        var charIndexes = new HashMap<Character, Integer>();
        var maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            var c = s.charAt(j);
            var index = charIndexes.get(c);
            if (index != null && index > i)
                i = index;
            var length = j - i + 1;
            if (length > maxLength)
                maxLength = length;
            charIndexes.put(c, j + 1);
        }
        return maxLength;
    }

    // java Solution.java "abcabcbb" "3" "bbbbb" "1" "pwwkew" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().lengthOfLongestSubstring(s), expected, s));
        }
    }
}
