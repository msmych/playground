class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        }
        var count = new int[26];
        s.chars().map(c -> c - 'a').forEach(c -> count[c]++);
        var min = 0;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(min)) {
                min = i;
            }
            if (--count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(min) + removeDuplicateLetters(s.substring(min + 1).replaceAll("" + s.charAt(min), ""));
    }

    // java Solution.java "bcabc" "abc" "cbacdcbc" "acdb"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().removeDuplicateLetters(s), expected, s));
        }
    }
}
