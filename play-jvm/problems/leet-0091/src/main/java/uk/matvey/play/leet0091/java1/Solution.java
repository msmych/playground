package uk.matvey.play.leet0091.java1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<String, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        if (s.isEmpty() || s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var n = Integer.parseInt(s.substring(0, 2));
        if (n % 10 == 0 && n != 10 && n != 20) {
            return 0;
        }
        if (s.length() == 2) {
            return n >= 1 && n <= 9 || n == 10 || n == 20 || n > 26 ? 1 : 2;
        }
        var num = numDecodings(s.substring(1));
        if (n <= 26) {
            num += numDecodings(s.substring(2));
        }
        cache.put(s, num);
        return num;
    }
}
