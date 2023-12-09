package uk.matvey.play.leet1328.java1;

public class Solution {
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
}
