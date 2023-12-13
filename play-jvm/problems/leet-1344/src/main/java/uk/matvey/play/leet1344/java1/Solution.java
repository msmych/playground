package uk.matvey.play.leet1344.java1;

import java.util.stream.DoubleStream;

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
