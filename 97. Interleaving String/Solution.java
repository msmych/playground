import java.util.*;

class Solution {

    private static class S123 {
        String s1, s2, s3;

        S123(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            S123 s123 = (S123) o;
            return Objects.equals(s1, s123.s1) &&
                    Objects.equals(s2, s123.s2) &&
                    Objects.equals(s3, s123.s3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s1, s2, s3);
        }
    }

    private final Map<S123, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s3.isEmpty()) {
            return true;
        }
        if (s1.isEmpty()) {
            return s3.equals(s2);
        }
        if (s2.isEmpty()) {
            return s3.equals(s1);
        }
        if (s3.equals(s1) || s3.equals(s2)) {
            return true;
        }
        var s123 = new S123(s1, s2, s3);
        if (cache.containsKey(s123)) {
            return cache.get(s123);
        }
        char first1 = s1.charAt(0), last1 = s1.charAt(s1.length() - 1),
            first2 = s2.charAt(0), last2 = s2.charAt(s2.length() - 1),
            first3 = s3.charAt(0), last3 = s3.charAt(s3.length() - 1);
        if (first1 != first3 && first2 != first3 || last1 != last3 && last2 != last3) {
            return false;
        }
        if (first1 == first2) {
            if (last1 == last3 && isInterleave(s1.substring(0, s1.length() - 1), s2, s3.substring(0, s3.length() - 1))) {
                cache.put(s123, true);
                return true;
            } else {
                var isInterleave = last2 == last3 && isInterleave(s1, s2.substring(0, s2.length() - 1), s3.substring(0, s3.length() - 1));
                cache.put(s123, isInterleave);
                return isInterleave;
            }
        } else {
            if (first1 == first3 && isInterleave(s1.substring(1), s2, s3.substring(1))) {
                cache.put(s123, true);
                return true;
            } else {
                var isInterleave = first2 == first3 && isInterleave(s1, s2.substring(1), s3.substring(1));
                cache.put(s123, isInterleave);
                return isInterleave;
            }
        }
    }

    // java Solution.java "aabcc" "dbbca" "aadbbcbcac" "true" "aabcc" "dbbca" "aadbbbaccc" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String s1 = args[i], s2 = args[i + 1], s3 = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s1 = %s, s2 = %s, s3 = %s",
                new Solution().isInterleave(s1, s2, s3), expected, s1, s2, s3));
        }
    }
}
