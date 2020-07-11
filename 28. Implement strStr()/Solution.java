class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) { 
            return -1;
        }
        for (var i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // java Solution.java "hello" "ll" "2" "aaaaa" "bba" "-1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String haystack = args[i], needle = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: haystack = %s, needle = %s",
                new Solution().strStr(haystack, needle), expected, haystack, needle));
        }
    }
}
