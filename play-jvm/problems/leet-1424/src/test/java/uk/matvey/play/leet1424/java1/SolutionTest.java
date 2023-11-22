package uk.matvey.play.leet1424.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

        int[] result = new Solution().findDiagonalOrder(nums);

        assertThat(result).containsExactly(1, 4, 2, 7, 5, 3, 8, 6, 9);
    }

    @Test
    public void case2() {
        var nums = List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7), List.of(8), List.of(9, 10, 11), List.of(12, 13, 14, 15, 16));

        int[] result = new Solution().findDiagonalOrder(nums);

        assertThat(result).containsExactly(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16);
    }

    @Test
    public void case3() {
        var nums = List.of(List.of(1, 2, 3), List.of(4), List.of(5, 6, 7), List.of(8), List.of(9, 10, 11));

        int[] result = new Solution().findDiagonalOrder(nums);

        assertThat(result).containsExactly(1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11);
    }

    @Test
    public void case4() {
        var nums = List.of(List.of(1, 2, 3, 4, 5, 6));

        int[] result = new Solution().findDiagonalOrder(nums);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
