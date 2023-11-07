package uk.matvey.play.leet1094.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var trips = new int[][]{{2, 1, 5}, {3, 3, 7}};

        boolean result = new Solution().carPooling(trips, 4);

        assertThat(result).isFalse();
    }

    @Test
    public void case2() {
        var trips = new int[][]{{2,1,5}, {3,3,7}};

        boolean result = new Solution().carPooling(trips, 5);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var trips = new int[][]{{2,1,5},{3,5,7}};

        boolean result = new Solution().carPooling(trips, 3);

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        var trips = new int[][]{{3,2,7},{3,7,9},{8,3,9}};

        boolean result = new Solution().carPooling(trips, 11);

        assertThat(result).isTrue();
    }
}
