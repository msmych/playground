package uk.matvey.play.leet0005.java1;

public class Solution {

    public String longestPalindrome(String s) {
        var longest = "";
        for (int mid = 0; mid < s.length(); mid++) {
            int i = mid;
            int j = mid;
            while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
                i--;
                j++;
            }
            if (j - i + 1 > longest.length()) {
                longest = s.substring(i, j + 1);
            }
            if (mid >= s.length() - 1 || s.charAt(mid) != s.charAt(mid + 1)) {
                continue;
            }
            i = mid;
            j = mid + 1;
            while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
                i--;
                j++;
            }
            if (j - i + 1 > longest.length()) {
                longest = s.substring(i, j + 1);
            }
         }
        return longest;
    }
}
