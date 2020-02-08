class Solution {

    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + '#' + reversed;
        int[] kmp = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int n = kmp[i - 1];
            while (n > 0 && combined.charAt(i) != combined.charAt(n)) {
                n = kmp[n - 1];
            }
            if (combined.charAt(i) == combined.charAt(n)) {
                n++;
            }
            kmp[i] = n;
        }
        return reversed.substring(0, s.length() - kmp[combined.length() - 1]) + s;
    }

    // java Solution.java "aacecaaa" "aaacecaaa" "abcd" "dcbabcd" "aacdaa" "aadcaacdaa" "" "" aaaaa aaaaa
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().shortestPalindrome(s), expected, s));
        }
    }
}
