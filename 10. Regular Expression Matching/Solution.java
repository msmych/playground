class Solution {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        var firstMatch = false;
        if (!s.isEmpty()) {
            var cs = s.charAt(0);
            var cp = p.charAt(0);
            firstMatch = cs == cp || cp == '.';
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    // java Solution.java "aa" "a" "false" "aa" "a*" "true" "ab" ".*" "true" "aab" "c*a*b" "true" "mississippi" "mis*is*p*." "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], p = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, p = %s",
                new Solution().isMatch(s, p), expected, s, p));
        }
    }
}
