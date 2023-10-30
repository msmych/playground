package uk.matvey.play.leet1356.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

        int[] result = new Solution().sortByBits(arr);

        assertThat(result).containsExactly(0, 1, 2, 4, 8, 3, 5, 6, 7);
    }

    @Test
    public void case2() {
        var arr = new int[]{1024,512,256,128,64,32,16,8,4,2,1};

        int[] result = new Solution().sortByBits(arr);

        assertThat(result).containsExactly(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    }
}
