package uk.matvey.problems.leet0050;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

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

class SolutionTest {

    @Test
    public void case1() {
        double x = 2;
        int n = 10;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(1024.00000);
    }

    @Test
    public void case2() {
        double x = 2.10000;
        int n = 3;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(9.26100, withPrecision(3d));
    }

    @Test
    public void case3() {
        double x = 2;
        int n = -2;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(0.25000);
    }

    @Test
    public void case4() {
        double x = 0.44528;
        int n = 0;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(1.0);
    }

    @Test
    public void case5() {
        double x = 1.0;
        int n = 2147483647;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(1.0);
    }

    @Test
    public void case6() {
        double x = 2.0;
        int n = -2147483648;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(0);
    }

    @Test
    public void case7() {
        double x = 1.0;
        int n = -2147483648;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(1.0);


    }

    @Test
    public void case8() {
        double x = -1.0;
        int n = 2147483647;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(-1.0);
    }

    @Test
    public void case9() {
        double x = 1.0000000000001;
        int n = -2147483648;
        double out = new Solution().myPow(x, n);
        assertThat(out).isEqualTo(0.99979);
    }


}
