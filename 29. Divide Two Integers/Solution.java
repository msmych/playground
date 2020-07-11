import static java.lang.Math.*;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = dividend < 0 == divisor < 0;
        long absDividend = abs((long) dividend);
        long absDivisor = abs((long) divisor);
        long quotient = 0;
        while (absDivisor <= absDividend) {
            long div = absDivisor;
            long i = 1;
            while (div <= absDividend) {
                div <<= 1;
                i <<= 1;
            }
            quotient += i >> 1;
            absDividend -= div >> 1;
        }
        if (positive && quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (positive ? quotient : ~quotient + 1);
    }

    // java Solution.java "10" "3" "3" "7" "-3" "-2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String dividend = args[i], divisor = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: dividend = %s, divisor = %s",
                new Solution().divide(Integer.parseInt(dividend), Integer.parseInt(divisor)), expected, dividend, divisor));
        }
    }
}
