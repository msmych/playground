package uk.matvey.play.leet0050.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

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