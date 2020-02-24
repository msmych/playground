class Solution {
    public int numberOfSubstrings(String s) {
        return 0;
    }

    // java Solution.java "abcabc" "10" "aaacb" "3" "abc" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().numberOfSubstrings(s), expected, s));
        }
    }
}
