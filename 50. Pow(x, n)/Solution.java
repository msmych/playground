import static java.lang.Math.*;

class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (x == 1) {
            return 1;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        } else if (n > 0) {
            return positivePower(x, n);
        } else {
            return negativePower(x, n);
        }
    }

    private double positivePower(double x, int n) {
        double p = x;
        for (; n > 1; n--) {
            if (abs(p) < 0.00001) {
                return 0;
            }
            p *= x;
        }
        return p;
    }

    private double negativePower(double x, int n) {
        double p = 1;
        for (; n < 0; n++) {
            if (abs(p) < 0.00001) {
                return 0;
            }
            p /= x;
        }
        return p;
    }

    // java Solution.java "2.00000" "10" "1024.00000" "2.10000" "3" "9.26100" "2.00000" "-2" "0.25000"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String x = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s, n = %s",
                new Solution().myPow(Double.parseDouble(x), Integer.parseInt(n)), expected, x, n));
        }
    }
}
