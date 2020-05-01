class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        var product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        return product * n;
    }

    // java Solution.java "2" "1" "10" "36"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().integerBreak(Integer.parseInt(n)), expected, n));
        }
    }
}
