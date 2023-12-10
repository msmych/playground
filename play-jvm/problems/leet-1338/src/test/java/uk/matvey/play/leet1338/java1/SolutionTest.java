package uk.matvey.play.leet1338.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var arr = new int[]{7, 7, 7, 7, 7, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        var arr = new int[]{1, 9};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var arr = new int[]{1000, 1000, 3, 7};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case5() {
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = new Solution().minSetSize(arr);

        assertThat(result).isEqualTo(5);
    }
}
