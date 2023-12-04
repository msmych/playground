package uk.matvey.play.leet1313.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 4};

        int[] result = new Solution().decompressRLElist(nums);

        assertThat(result).containsExactly(2, 4, 4, 4);
    }
}
