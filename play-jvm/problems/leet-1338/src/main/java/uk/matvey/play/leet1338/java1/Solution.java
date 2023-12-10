package uk.matvey.play.leet1338.java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int minSetSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        List<Integer> occurrences = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)))
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        int i = 0;
        for (int sum = 0; sum < arr.length / 2; i++) {
            sum += occurrences.get(i);
        }
        return i;
    }
}
