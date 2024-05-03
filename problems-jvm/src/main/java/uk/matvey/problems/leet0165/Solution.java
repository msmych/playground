package uk.matvey.problems.leet0165;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int compareVersion(String version1, String version2) {
        var revisions1 = getRevisions(version1);
        var revisions2 = getRevisions(version2);
        for (int i = 0; i < Math.min(revisions1.length, revisions2.length); i++) {
            int r1 = revisions1[i];
            int r2 = revisions2[i];
            if (r1 != r2) {
                return r1 > r2 ? 1 : -1;
            }
        }
        if (revisions1.length > revisions2.length) {
            return compareExtraRevisions(revisions1, revisions2);
        } else if (revisions2.length > revisions1.length) {
            return -compareExtraRevisions(revisions2, revisions1);
        }
        return 0;
    }

    private Integer[] getRevisions(String version1) {
        return Arrays.stream(version1.split("\\."))
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
    }

    private int compareExtraRevisions(Integer[] revisions1, Integer[] revisions2) {
        return Arrays.stream(revisions1)
            .skip(revisions2.length)
            .anyMatch(r -> r > 0)
            ? 1
            : 0;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().compareVersion("0.1", "1.1")).isEqualTo(-1);
    }

    @Test
    void case2() {
        assertThat(new Solution().compareVersion("1.0.1", "1")).isEqualTo(1);
    }

    @Test
    void case3() {
        assertThat(new Solution().compareVersion("7.5.2.4", "7.5.3")).isEqualTo(-1);
    }

    @Test
    void case4() {
        assertThat(new Solution().compareVersion("1.01", "1.001")).isEqualTo(0);
    }

    @Test
    void case5() {
        assertThat(new Solution().compareVersion("1.0", "1.0.0")).isEqualTo(0);
    }
}