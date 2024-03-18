package uk.matvey.problems.leet1331;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        for (int i = 0, rank = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], ++rank);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{40, 10, 20, 30};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(4, 1, 2, 3);
    }

    @Test
    public void case2() {
        var arr = new int[]{100, 100, 100};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(1, 1, 1);
    }

    @Test
    public void case3() {
        var arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(5, 3, 4, 2, 8, 6, 7, 1, 3);
    }
}
