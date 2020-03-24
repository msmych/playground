class Solution {
    public String longestPrefix(String s) {
        return "";
    }

    // java Solution.java "level" "l" "ababab" "abab" "leetcodeleet" "leet" "a" ""
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().longestPrefix(s), expected, s));
        }
    }
}
