package uk.matvey.problems.leet1450;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        return (int) IntStream.range(0, startTime.length)
            .filter(i -> startTime[i] <= queryTime)
            .filter(i -> endTime[i] >= queryTime)
            .count();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var startTime = new int[]{1, 2, 3};
        var endTime = new int[]{3, 2, 7};

        var result = new Solution().busyStudent(startTime, endTime, 4);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        var startTime = new int[]{4};
        var endTime = new int[]{4};

        var result = new Solution().busyStudent(startTime, endTime, 4);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        var startTime = new int[]{4};
        var endTime = new int[]{4};

        var result = new Solution().busyStudent(startTime, endTime, 5);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        var startTime = new int[]{1, 1, 1, 1};
        var endTime = new int[]{1, 3, 2, 4};

        var result = new Solution().busyStudent(startTime, endTime, 7);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case5() {
        var startTime = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        var endTime = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10};

        var result = new Solution().busyStudent(startTime, endTime, 5);

        assertThat(result).isEqualTo(5);
    }
}
