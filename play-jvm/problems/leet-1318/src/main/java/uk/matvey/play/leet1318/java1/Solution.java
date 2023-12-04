package uk.matvey.play.leet1318.java1;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class Solution {
    public int minFlips(int a, int b, int c) {
        String sa = Integer.toString(a, 2);
        String sb = Integer.toString(b, 2);
        String sc = Integer.toString(c, 2);
        IntSummaryStatistics stats = Stream.of(sa, sb, sc)
                .mapToInt(String::length)
                .summaryStatistics();
        int maxLen = stats.getMax();
        int minLen = stats.getMin();
        for (int i = minLen; i < maxLen; i++) {
            if (sa.length() == i) {
                sa = "0" + sa;
            }
            if (sb.length() == i) {
                sb = "0" + sb;
            }
            if (sc.length() == i) {
                sc = "0" + sc;
            }
        }
        int flips = 0;
        for (int i = 0; i < maxLen; i++) {
            if (sc.charAt(i) == '1') {
                if (sa.charAt(i) == '0' && sb.charAt(i) == '0') {
                    flips++;
                }
            } else {
                if (sa.charAt(i) == '1') {
                    flips++;
                }
                if (sb.charAt(i) == '1') {
                    flips++;
                }
            }
        }
        return flips;
    }
}
