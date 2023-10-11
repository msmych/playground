package uk.matvey.play.leet2251.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.matvey.play.utils.CaseParamsReader.CASE_PARAMS_READER;

public class SolutionTest {

    @Test
    public void case1() {
        var flowers = new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        var people = new int[]{2, 3, 7, 11};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(1, 2, 2, 2);
    }

    @Test
    public void case2() {
        var flowers = new int[][]{{1, 10}, {3, 3}};
        var people = new int[]{3, 3, 2};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(2, 2, 1);
    }

    @Test
    public void case3() {
        var flowers = new int[][]{{19, 37}, {19, 38}, {19, 35}};
        var people = new int[]{6, 7, 21, 1, 13, 37, 5, 37, 46, 43};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(0, 0, 3, 0, 0, 2, 0, 2, 0, 0);
    }

    @Test
    public void case4() {
        int[][] flowers = CASE_PARAMS_READER.parseIntArrArr(CASE_PARAMS_READER.readString("case4/flowers.txt"));
        int[] people = CASE_PARAMS_READER.parseIntArr(CASE_PARAMS_READER.readString("case4/people.txt"));
        int[] expected = CASE_PARAMS_READER.parseIntArr(CASE_PARAMS_READER.readString("case4/expected.txt"));

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(expected);
    }
}
