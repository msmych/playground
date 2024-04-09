package uk.matvey.problems.leet1442;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int countTriplets(int[] arr) {
        var xors = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((xors[j + 1] ^ xors[i]) == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var arr = new int[]{2, 3, 1, 6, 7};

        var result = new Solution().countTriplets(arr);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        var arr = new int[]{1, 1, 1, 1, 1};

        var result = new Solution().countTriplets(arr);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void case3() {
        var arr = new int[]{2, 3};

        var result = new Solution().countTriplets(arr);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        var arr = new int[]{1, 3, 5, 7, 9};

        var result = new Solution().countTriplets(arr);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case5() {
        var arr = new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22};

        var result = new Solution().countTriplets(arr);

        assertThat(result).isEqualTo(8);
    }
}
