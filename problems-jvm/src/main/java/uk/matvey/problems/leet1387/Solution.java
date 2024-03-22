package uk.matvey.problems.leet1387;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int getKth(int lo, int hi, int k) {
        return IntStream.rangeClosed(lo, hi)
            .mapToObj(this::power)
            .sorted((a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            })
            .map(a -> a[0])
            .skip(k - 1)
            .findFirst()
            .get();
    }

    private int[] power(int num) {
        int power = 0;
        for (int n = num; n != 1; power++) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return new int[]{num, power};
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().getKth(12, 15, 2)).isEqualTo(13);
    }

    @Test
    void case2() {
        assertThat(new Solution().getKth(1, 1, 1)).isEqualTo(1);
    }

    @Test
    void case3() {
        assertThat(new Solution().getKth(7, 11, 4)).isEqualTo(7);
    }

    @Test
    void case4() {
        assertThat(new Solution().getKth(10, 20, 5)).isEqualTo(13);
    }

    @Test
    void case5() {
        assertThat(new Solution().getKth(1, 1000, 777)).isEqualTo(570);
    }
}
