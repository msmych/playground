class Solution {

    public String thousandSeparator(int n) {
        var s = Integer.toString(n);
        var sb = new StringBuilder(s);
        for (var i = s.length() - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }
        return sb.toString();
    }

    // java Solution.java "987" "987" "1234" "1.234" "123456789" "123.456.789" "0" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().thousandSeparator(Integer.parseInt(n)), expected, n));
        }
    }
}
