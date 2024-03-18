package uk.matvey.problems.leet1344;

import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public double angleClock(int hour, int minutes) {
        double minutesAngle = 6.0 * minutes;
        double hourAngle = 30.0 * (hour % 12) + 30.0 * (minutes / 60.0);
        return DoubleStream.of(
                Math.abs(hourAngle - minutesAngle),
                360.0 - hourAngle + minutesAngle,
                360.0 - minutesAngle + hourAngle)
            .min()
            .getAsDouble();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        double result = new Solution().angleClock(12, 30);

        assertThat(result).isEqualTo(165.0);
    }

    @Test
    public void case2() {
        double result = new Solution().angleClock(3, 30);

        assertThat(result).isEqualTo(75.0);
    }

    @Test
    public void case3() {
        double result = new Solution().angleClock(3, 15);

        assertThat(result).isEqualTo(7.5);
    }

    @Test
    public void case4() {
        double result = new Solution().angleClock(4, 50);

        assertThat(result).isEqualTo(155);
    }

    @Test
    public void case5() {
        double result = new Solution().angleClock(12, 0);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case6() {
        double result = new Solution().angleClock(1, 57);

        assertThat(result).isEqualTo(76.5);
    }
}
