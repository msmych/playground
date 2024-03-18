package uk.matvey.problems.leet1360;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(
            Duration.between(
                    Instant.parse(date1 + "T00:00:00.00Z"),
                    Instant.parse(date2 + "T00:00:00.00Z")
                )
                .toDays()
        );
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().daysBetweenDates("2019-06-29", "2019-06-30")).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().daysBetweenDates("2020-01-15", "2019-12-31")).isEqualTo(15);
    }
}
