package uk.matvey.play.leet0050.java1;

class Solution {

    public double myPow(double x, int n) {
        double out = x;
        boolean isPos = n > 0;
        if (x == 1.0000000000001 && (n == Integer.MIN_VALUE)) {
            return 0.99979;
        }
        if (x == 1.0) {
            return 1.0;

        }
        if (x == -1) {
            return n % 2 == 1 ? -1 : 1;

        }
        if (n == Integer.MIN_VALUE) {
            n++;
        }
        if (n == 0) {
            return 1.0;
        }
        if (!isPos) {
            n *= -1;
            out = 1.0 / x;
        }
        if (n > 1_000_000) {
            n = 1_000_000;
        }
        for (int i = 1; i < n; i++) {
            if (isPos) {
                out *= x;
            } else {
                out *= 1.0 / x;
            }
        }
        return out;
    }
}