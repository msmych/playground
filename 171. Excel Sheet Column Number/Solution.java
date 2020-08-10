class Solution {

    public int titleToNumber(String s) {
        int num = 0, d = 1;
        for (var i = 0; i < s.length(); i++) {
            num += (s.charAt(s.length() - i - 1) - 'A' + 1) * d;
            d *= 'Z' - 'A' + 1;
        }
        return num;
    }

    // java Solution.java "A" "1" "AB" "28" "ZY" "701"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().titleToNumber(s), expected, s));
        }
    }
}
