class Solution {

    private String longestPalindrome = "";

    public String longestPalindrome(String s) {
        int delta;
        for (int i = 0; i < s.length(); i++) {
            delta = 0;
            while (delta <= i && i + delta < s.length()) {
                if (isEvenPalindrome(s, i, delta)) {
                    updateLongestPalindrome(s.substring(i - delta, i + delta + 2));
                } else if (isOddPalindrome(s, i, delta)) {
                    updateLongestPalindrome(s.substring(i - delta, i + delta + 1));
                } else break;
                delta++;
            }
        }
        return longestPalindrome;
    }

    private boolean isOddPalindrome(String s, int i, int delta) {
        if (delta == 0) return true;
        return s.charAt(i - delta + 1) == s.charAt(i + delta - 1) && s.charAt(i - delta) == s.charAt(i + delta);
    }

    private boolean isEvenPalindrome(String s, int i, int delta) {
        if (i + delta + 1 >= s.length()) return false;
        if (delta == 0) return s.charAt(i) == s.charAt(i + 1);
        return s.charAt(i) == s.charAt(i + 1) && s.charAt(i - delta + 1) == s.charAt(i + delta) && s.charAt(i - delta) == s.charAt(i + delta + 1);
    }

    private void updateLongestPalindrome(String palindrome) {
        if (longestPalindrome.length() < palindrome.length()) {
            longestPalindrome = palindrome;
        }
    }

    // java Solution.java "babad" "bab" "cbbd" "bb"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().longestPalindrome(s), expected, s));
        }
    }
}
