package uk.matvey.play.leet1481.java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
