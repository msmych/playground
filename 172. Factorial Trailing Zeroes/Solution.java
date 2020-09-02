class Solution {

    public int trailingZeroes(int n) {
        var zeroes = 0;
        for (var i = 5; i <= n; i *= 5) {
            zeroes += n / i;
        }
        return zeroes;
    }

    // java Solution.java "3" "0" "5" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().trailingZeroes(Integer.parseInt(n)), expected, n));
        }
    }
}
