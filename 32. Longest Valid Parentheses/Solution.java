import java.util.*;

import static java.lang.Math.*;

class Solution {

    private class FromTo {
        int from;
        int to;

        FromTo(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FromTo fromTo = (FromTo) o;
            return from == fromTo.from &&
                    to == fromTo.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    private final Map<FromTo, Integer> cache = new HashMap<>();
    private String s;

    public int longestValidParentheses(String s) {
        this.s = s;
        return getLongest(0, s.length());
    }

    private int getLongest(int from, int to) {
        if (from == to) {
            return 0;
        }
        var fromTo = new FromTo(from, to);
        if (cache.containsKey(fromTo)) {
            return cache.get(fromTo);
        }
        var sub = s.substring(from, to);
        if (!sub.contains(")")) {
            cache.put(fromTo, 0);
            return 0;
        }
        int i = from, index = 0;
        while (i < to && index >= 0) {
            if (s.charAt(i) == '(') {
                index++;
            } else {
                index--;
            }
            i++;
        }
        int longest;
        if (index == 0) {
            longest = i - from;
        } else if (index > 0) {
            longest = getLongestRightToLeft(to, from);
        } else {
            longest = Math.max(i - from - 1, getLongest(i, to));
        }
        cache.put(fromTo, longest);
        return longest;
    }

    private int getLongestRightToLeft(int from, int to) {
        if (from == to) {
            return 0;
        }
        int i = from - 1, index = 0;
        while (i >= to && index >= 0) {
            if (s.charAt(i) == ')') {
                index++;
            } else {
                index--;
            }
            i--;
        }
        int longest = max(from - i - 2, getLongest(to, i + 1));
        cache.put(new FromTo(to, from), longest);
        return longest;
    }

    // java Solution.java "(()" "2" ")()())" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().longestValidParentheses(s), expected, s));
        }
    }
}
