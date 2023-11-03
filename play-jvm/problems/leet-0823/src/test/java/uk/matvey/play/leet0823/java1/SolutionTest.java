package uk.matvey.play.leet0823.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.utils.TestCaseReader;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{2, 4};

        int result = new Solution().numFactoredBinaryTrees(arr);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var arr = new int[]{2, 4, 5, 10};

        int result = new Solution().numFactoredBinaryTrees(arr);

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void case3() {
        var testCaseReader = new TestCaseReader("case3");
        var arr = testCaseReader.parseIntArr("/arr.txt");

        int result = new Solution().numFactoredBinaryTrees(arr);

        assertThat(result).isEqualTo(874417692);
    }
}