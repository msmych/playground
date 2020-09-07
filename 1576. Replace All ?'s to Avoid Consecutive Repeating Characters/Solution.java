class Solution {

    public String modifyString(String s) {
        var sb = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                var left = i == 0 ? '?' : sb.charAt(i - 1);
                var right = i == s.length() - 1 ? '?' : s.charAt(i + 1);
                sb.append(avoid(left, right));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private char avoid(char a, char b) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (c != a && c != b) {
                return c;
            }
        }
        throw new IllegalArgumentException();
    }

    // java Solution.java "?zs" "azs" "ubv?w" "ubvaw" "j?qg??b" "jaqgacb" "??yw?ipkj?" "acywaipkja"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().modifyString(s), expected, s));
        }
    }
}
