package uk.matvey.play.leet0119.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().getRow(3);

        assertThat(result).containsExactly(1, 3, 3, 1);
    }
}
