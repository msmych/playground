import java.util.stream.DoubleStream;

import static java.lang.Math.abs;

class Solution {

    public double angleClock(int hour, int minutes) {
        double minutesAngle = 6.0 * minutes;
        double hourAngle = 30.0 * (hour % 12) + 30.0 * (minutes / 60.0);
        return DoubleStream.of(
            abs(hourAngle - minutesAngle),
            360.0 - hourAngle + minutesAngle,
            360.0 - minutesAngle + hourAngle)
            .min()
            .getAsDouble();
    }

    // java Solution.java "12" "30" "165" "3" "30" "75" "3" "15" "7.5" "4" "50" "155" "12" "0" "0" 1 57 76.5
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String hour = args[i], minutes = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: hour = %s, minutes = %s",
                new Solution().angleClock(Integer.parseInt(hour), Integer.parseInt(minutes)), expected, hour, minutes));
        }
    }
}
