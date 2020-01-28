class Solution {
    public String breakPalindrome(String palindrome) {
        for (int i = 0; i < palindrome.length(); i++) {
            if ((palindrome.length() % 2 == 0 || i != palindrome.length() / 2) && palindrome.charAt(i) > 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
            if (palindrome.length() > 1 && i == palindrome.length() - 1) {
                return palindrome.substring(0, i) + 'b' + palindrome.substring(i + 1);
            }
        }
        return "";
    }

    // java Solution.java "abccba" "aaccba" "a" "" aa ab aba abb
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String palindrome = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: palindrome = %s",
                new Solution().breakPalindrome(palindrome), expected, palindrome));
        }
    }
}
