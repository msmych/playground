package uk.matvey.problems.leet1481;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var uniques = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)))
            .entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getValue))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        for (var iterator = uniques.entrySet().iterator(); iterator.hasNext() && k > 0;) {
            int count = iterator.next().getValue();
            k -= count;
            if (k >= 0) {
                iterator.remove();
            }
        }
        return uniques.size();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{5, 5, 4};

        int result = new Solution().findLeastNumOfUniqueInts(arr, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        var arr = new int[]{4, 3, 1, 1, 3, 3, 2};

        int result = new Solution().findLeastNumOfUniqueInts(arr, 3);

        assertThat(result).isEqualTo(2);
    }
}
