package uk.matvey.play.leet2904.java1;

import java.util.LinkedList;

public class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        var ones = new LinkedList<Integer>();
        var minSub = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.offer(i);
                if (ones.size() > k) {
                    ones.poll();
                }
                if (ones.size() == k) {
                    var sub = s.substring(ones.getFirst(), i + 1);
                    if (minSub.isEmpty()) {
                        minSub = sub;
                    } else if (sub.length() < minSub.length()) {
                        minSub = sub;
                    } else if (sub.length() == minSub.length() && sub.compareTo(minSub) < 0) {
                        minSub = sub;
                    }
                }
            }
        }
        return minSub;
    }
}
