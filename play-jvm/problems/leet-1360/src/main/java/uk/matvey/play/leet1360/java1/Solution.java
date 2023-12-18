package uk.matvey.play.leet1360.java1;

import java.time.Duration;
import java.time.Instant;

public class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(Duration.between(
                        Instant.parse(date1 + "T00:00:00.00Z"),
                        Instant.parse(date2 + "T00:00:00.00Z"))
                .toDays());
    }
}
