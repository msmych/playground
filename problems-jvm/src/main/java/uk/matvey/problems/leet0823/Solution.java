package uk.matvey.problems.leet0823;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        var map = Arrays.stream(arr).boxed().collect(Collectors.toMap(i -> i, i -> 1L));
        int mod = 1_000_000_007;
        for (int n : arr) {
            for (int f : arr) {
                if (f == n) {
                    break;
                }
                if (n % f == 0 && map.containsKey(n / f)) {
                    map.merge(n, map.get(f) * map.get(n / f) % mod, (a, b) -> (a + b) % mod);
                }
            }
        }
        return map.values().stream().mapToLong(i -> i).mapToInt(i -> (int) i).reduce(0, (a, b) -> (a + b) % mod);
    }
}

class SolutionTest {

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
        var arr = new TestCaseReader("leet0823/case3").parseIntArr("/arr.txt");

        int result = new Solution().numFactoredBinaryTrees(arr);

        assertThat(result).isEqualTo(874417692);
    }
}
