package uk.matvey.problems.leet0128;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fromIntervals = new HashMap<>(), toIntervals = new HashMap<>();
        for (var num : nums) {
            if (fromIntervals.containsKey(num) || toIntervals.containsKey(num)) {
                continue;
            }
            if (!fromIntervals.containsKey(num + 1) && !toIntervals.containsKey(num - 1)) {
                fromIntervals.put(num, num);
                toIntervals.put(num, num);
            } else if (fromIntervals.containsKey(num + 1)) {
                var to = fromIntervals.get(num + 1);
                fromIntervals.remove(num + 1);
                fromIntervals.put(num, to);
                toIntervals.put(to, num);
            } else {
                var from = toIntervals.get(num - 1);
                toIntervals.remove(num - 1);
                toIntervals.put(num, from);
                fromIntervals.put(from, num);
            }
        }
        for (var join : toIntervals.keySet().stream().filter(to -> fromIntervals.containsKey(to + 1)).toList()) {
            int from = toIntervals.get(join), to = fromIntervals.get(join + 1);
            fromIntervals.put(from, to);
            toIntervals.put(to, from);
            fromIntervals.remove(join + 1);
            toIntervals.remove(join);
        }
        return fromIntervals.entrySet().stream().mapToInt(entry -> entry.getValue() - entry.getKey() + 1).max().orElse(0);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{100, 4, 200, 1, 3, 2};

        int result = new Solution().longestConsecutive(nums);

        assertThat(result).isEqualTo(4);
    }
}
