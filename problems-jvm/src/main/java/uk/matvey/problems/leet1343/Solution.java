package uk.matvey.problems.leet1343;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double average = IntStream.range(0, k)
            .mapToDouble(i -> (double) arr[i])
            .average()
            .getAsDouble();
        int num = 0;
        if (average >= threshold) {
            num++;
        }
        for (int i = k; i < arr.length; i++) {
            average += (double) (arr[i] - arr[i - k]) / (double) k;
            if (average >= threshold) {
                num++;
            }
        }
        return num;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};

        int result = new Solution().numOfSubarrays(arr, 3, 4);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var arr = new int[]{1, 1, 1, 1, 1};

        int result = new Solution().numOfSubarrays(arr, 1, 0);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case3() {
        var arr = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};

        int result = new Solution().numOfSubarrays(arr, 3, 5);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case4() {
        var arr = new int[]{7, 7, 7, 7, 7, 7, 7};

        int result = new Solution().numOfSubarrays(arr, 7, 7);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case5() {
        var arr = new int[]{4, 4, 4, 4};

        int result = new Solution().numOfSubarrays(arr, 4, 1);

        assertThat(result).isEqualTo(1);
    }
}
