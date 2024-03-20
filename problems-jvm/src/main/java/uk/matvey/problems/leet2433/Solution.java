package uk.matvey.problems.leet2433;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] findArray(int[] pref) {
        var arr = new int[pref.length];
        int last = 0;
        for (int i = 0; i < pref.length; i++) {
            arr[i] = last ^ pref[i];
            last = pref[i];
        }
        return arr;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var pref = new int[]{5, 2, 0, 3, 1};

        int[] result = new Solution().findArray(pref);

        assertThat(result).containsExactly(5, 7, 2, 3, 2);
    }

    @Test
    public void case2() {
        var pref = new int[]{13};

        int[] result = new Solution().findArray(pref);

        assertThat(result).containsExactly(13);
    }
}
