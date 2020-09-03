class Solution {

    public boolean repeatedSubstringPattern(String s) {
        for (var i = 1; i <= s.length() / 2; i += s.length() % 2 == 0 ? 1 : 2) {
            if (s.length() % i != 0) {
                continue;
            }
            var part = s.substring(0, i);
            var repeating = true;
            for (var j = 0; j < s.length() / i; j++) {
                if (!s.substring(i * j, i * j + i).equals(part)) {
                    repeating = false;
                    break;
                }
            }
            if (repeating) {
                return true;
            }
        }
        return false;
    }

    // java Solution.java "abab" "true" "aba" "false" "abcabcabcabc" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().repeatedSubstringPattern(s), expected, s));
        }
    }
}
