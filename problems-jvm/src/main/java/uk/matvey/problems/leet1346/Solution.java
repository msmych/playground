package uk.matvey.problems.leet1346;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean checkIfExist(int[] arr) {
        var set = new HashSet<Integer>();
        for (int n : arr) {
            if (set.contains(2 * n) || n % 2 == 0 && set.contains(n / 2)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}

class SolutionTest {

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
