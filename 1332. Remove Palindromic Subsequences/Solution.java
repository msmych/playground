class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return 2;
            }
        }
        return 1;
    }

    // java Solution.java "ababa" "1" "abb" "2" "baabb" "2" "" "0" ababb 2 "baabaaaababbbbaabbabbbbaabbabbababaaababababbabbab" 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().removePalindromeSub(s), expected, s));
        }
    }
}
