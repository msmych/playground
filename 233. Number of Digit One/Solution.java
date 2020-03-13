import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long d = 1; d <= n; d *= 10) {
            long dd = d * 10;
            count += (n / dd) * d + min(max(n % dd - d + 1, 0), d);
        }
        return count;
    }

    // java Solution.java "13" "6" -1 0
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countDigitOne(Integer.parseInt(n)), expected, n));
        }
    }
}
