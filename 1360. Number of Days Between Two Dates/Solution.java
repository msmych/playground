import static java.lang.Math.abs;

import java.time.Duration;
import java.time.Instant;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return (int) abs(Duration.between(
            Instant.parse(date1 + "T00:00:00.00Z"), 
            Instant.parse(date2 + "T00:00:00.00Z"))
            .toDays());
    }

    // java Solution.java "2019-06-29" "2019-06-30" "1" "2020-01-15" "2019-12-31" "15"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String date1 = args[i], date2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: date1 = %s, date2 = %s",
                new Solution().daysBetweenDates(date1, date2), expected, date1, date2));
        }
    }
}
