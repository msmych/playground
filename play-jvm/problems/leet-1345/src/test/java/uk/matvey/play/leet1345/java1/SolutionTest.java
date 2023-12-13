package uk.matvey.play.leet1345.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var arr = new int[]{7};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        var arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var arr = new int[]{6, 1, 9};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case5() {
        var arr = new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(3);
    }
}
