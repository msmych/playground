package uk.matvey.play.leet1346.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{10, 2, 5, 3};

        boolean result = new Solution().checkIfExist(arr);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var arr = new int[]{7, 1, 14, 11};

        boolean result = new Solution().checkIfExist(arr);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var arr = new int[]{3, 1, 7, 11};

        boolean result = new Solution().checkIfExist(arr);

        assertThat(result).isFalse();
    }
}
