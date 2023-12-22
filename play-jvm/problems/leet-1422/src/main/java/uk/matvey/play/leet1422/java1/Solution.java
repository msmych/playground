package uk.matvey.play.leet1422.java1;

public class Solution {
    public int maxScore(String s) {
        var ones = new int[s.length() + 1];
        for (var i = 0; i < s.length(); i++) {
            ones[i + 1] = s.charAt(i) == '1' ? ones[i] + 1 : ones[i];
        }
        var zeroes = 0;
        var max = 0;
        for (var i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            var score = zeroes + ones[ones.length - 1] - ones[i + 1];
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
}
