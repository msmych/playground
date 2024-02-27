package uk.matvey.play.leet0787.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.utils.TestCaseParamsParser;
import uk.matvey.play.utils.TestCaseReader;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int result = new Solution().findCheapestPrice(3, flights, 0, 2, 1);

        assertThat(result).isEqualTo(200);
    }

    @Test
    public void case2() {
        var flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int result = new Solution().findCheapestPrice(3, flights, 0, 2, 0);

        assertThat(result).isEqualTo(500);
    }

    @Test
    public void case3() {
        var flights = new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};

        int result = new Solution().findCheapestPrice(5, flights, 2, 1, 1);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void case4() {
        var flights = new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}};

        int result = new Solution().findCheapestPrice(10, flights, 6, 0, 7);

        assertThat(result).isEqualTo(14);
    }

    @Test
    public void case5() {
        var flights = new TestCaseReader("case5").parseIntArrArr("flights.txt");

        int result = new Solution().findCheapestPrice(13, flights, 10, 1, 10);

        assertThat(result).isEqualTo(-1);
    }
}
