import java.util.*;

class Solution {

    private static class Visited {
        int si, sj, pi, pj;

        Visited(int si, int sj, int pi, int pj) {
            this.si = si;
            this.sj = sj;
            this.pi = pi;
            this.pj = pj;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Visited visited = (Visited) o;
            return si == visited.si &&
                sj == visited.sj &&
                pi == visited.pi &&
                pj == visited.pj;
        }

        @Override
        public int hashCode() {
            return Objects.hash(si, sj, pi, pj);
        }
    }

    private final Map<Visited, Boolean> cache = new HashMap<>();

    private char[] s, p;

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = collapsed(p);
        return isMatchFromHead(0, this.s.length - 1, 0, this.p.length - 1);
    }

    private char[] collapsed(String p) {
        var chars = new char[p.length()];
        var isStar = false;
        var k = 0;
        for (var c : p.toCharArray()) {
            if (c == '*') {
                if (!isStar) {
                    chars[k++] = c;
                    isStar = true;
                }
            } else {
                chars[k++] = c;
                isStar = false;
            }
        }
        return Arrays.copyOfRange(chars, 0, k);
    }

    private boolean isMatchFromHead(int si, int sj, int pi, int pj) {
        var visited = new Visited(si, sj, pi, pj);
        if (cache.containsKey(visited)) {
            return cache.get(visited);
        }
        if (pi > pj) {
            return si > sj;
        }
        if (si > sj) {
            return pi == pj && p[pi] == '*';
        }
        var c = p[pi];
        if (c == '?') {
            var match = isMatchFromHead(si + 1, sj, pi + 1, pj);
            cache.put(visited, match);
            return match;
        }
        if (c != '*') {
            var match = s[si] == c && isMatchFromHead(si + 1, sj, pi + 1, pj);
            cache.put(visited, match);
            return match;
        }
        var match = isMatchFromTail(si, sj, pi, pj);
        cache.put(visited, match);
        return match;
    }

    private boolean isMatchFromTail(int si, int sj, int pi, int pj) {
        if (pi > pj) {
            return si > sj;
        }
        if (si > sj) {
            return pi == pj && p[pj] == '*';
        }
        var c = p[pj];
        if (c == '?') {
            return isMatchFromTail(si, sj - 1, pi, pj - 1);
        }
        if (c != '*') {
            return s[sj] == c && isMatchFromTail(si, sj - 1, pi, pj - 1);
        }
        return isMatchFromHead(si, sj, pi + 1, pj) || isMatchFromHead(si + 1, sj, pi, pj);
    }

    // java Solution.java "aa" "a" "false" "aa" "*" "true" "cb" "?a" "false" "adceb" "*a*b" "true" "acdcb" "a*c?b" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], p = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, p = %s",
                new Solution().isMatch(s, p), expected, s, p));
        }
    }
}
