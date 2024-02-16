package uk.matvey.play.leet1481.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{5, 5, 4};

        int result = new Solution().findLeastNumOfUniqueInts(arr, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        var arr = new int[]{4, 3, 1, 1, 3, 3, 2};

        int result = new Solution().findLeastNumOfUniqueInts(arr, 3);

        assertThat(result).isEqualTo(2);
    }
}
