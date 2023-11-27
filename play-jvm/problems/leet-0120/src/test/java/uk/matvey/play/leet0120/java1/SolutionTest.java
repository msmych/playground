package uk.matvey.play.leet0120.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));

        int result = new Solution().minimumTotal(triangle);

        assertThat(result).isEqualTo(11);
    }
}
