package uk.matvey.problems.leet0201;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().rangeBitwiseAnd(5, 7);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        int result = new Solution().rangeBitwiseAnd(0, 0);

        assertThat(result).isEqualTo(0);
    }
}
