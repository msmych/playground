package uk.matvey.problems.leet1405;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        var map = new HashMap<Character, Integer>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        return nextDiverse(map, '0');
    }

    private String nextDiverse(Map<Character, Integer> map, char last) {
        if (map.values().stream().allMatch(v -> v == 0)) {
            return "";
        }
        var max = map.entrySet().stream()
            .max(Comparator.comparingInt(Map.Entry::getValue)).get();
        if (max.getKey() == last) {
            if (map.entrySet().stream()
                .filter(e -> e.getKey() != max.getKey())
                .allMatch(e -> e.getValue() == 0)) {
                return "";
            }
            var mid = map.entrySet().stream()
                .filter(e -> e.getKey() != max.getKey())
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey).get();
            map.merge(mid, -1, Integer::sum);
            return mid + nextDiverse(map, mid);
        } else {
            if (max.getValue() > 1) {
                map.merge(max.getKey(), -2, Integer::sum);
                return max.getKey() + "" + max.getKey() + nextDiverse(map, max.getKey());
            } else {
                map.merge(max.getKey(), -1, Integer::sum);
                return max.getKey() + nextDiverse(map, max.getKey());
            }
        }
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().longestDiverseString(1, 1, 7)).isEqualTo("ccaccbcc");
    }

    @Test
    void case2() {
        assertThat(new Solution().longestDiverseString(2, 2, 1)).isEqualTo("aabbc");
    }

    @Test
    void case3() {
        assertThat(new Solution().longestDiverseString(7, 1, 0)).isEqualTo("aabaa");
    }
}
