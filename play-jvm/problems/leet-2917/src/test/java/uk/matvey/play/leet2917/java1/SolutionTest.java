package uk.matvey.play.leet2917.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{7, 12, 9, 8, 9, 15};

        int result = new Solution().findKOr(nums, 4);

        assertThat(result).isEqualTo(9);
    }

    @Test
    public void case2() {
        var nums = new int[]{2, 12, 1, 11, 4, 5};

        int result = new Solution().findKOr(nums, 6);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        var nums = new int[]{10, 8, 5, 9, 11, 6, 8};

        int result = new Solution().findKOr(nums, 1);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void case4() {
        var nums = new int[]{925011496, 103855710, 1584980217, 1804943441, 904176743, 71227402, 658339386, 1949490684, 394057351, 1504638274, 936036729, 516283059, 995417756, 1370320334, 1501991237, 578607899, 981063549, 1950398619, 780236107, 258555692, 2055224506, 521917008, 1643308943, 522924296, 1115988653, 136177651, 2112081121, 1411190147, 1059197244, 1476196073, 1563551833, 477789887, 1901104327, 752532861, 824056222};

        int result = new Solution().findKOr(nums, 16);

        assertThat(result).isEqualTo(1065156095);
    }
}
