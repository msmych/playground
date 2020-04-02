class Solution {
    public String smallestSubsequence(String text) {
        if (text.isEmpty()) {
            return "";
        }
        var count = new int[26];
        text.chars().map(c -> c - 'a').forEach(c -> count[c]++);
        var min = 0;
        for (var i = 0; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(min)) {
                min = i;
            }
            if (--count[text.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return text.charAt(min) + smallestSubsequence(text.substring(min + 1).replaceAll("" + text.charAt(min), ""));
    }

    // java Solution.java "cdadabcc" "adbc" "abcd" "abcd" "ecbacba" "eacb" "leetcode" "letcod"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String text = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text = %s",
                new Solution().smallestSubsequence(text), expected, text));
        }
    }
}
