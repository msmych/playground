package uk.matvey.problems.leet1313;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int[] decompressRLElist(int[] nums) {
        var split = IntStream.range(0, nums.length)
            .boxed()
            .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> lens = split.get(true).stream().map(i -> nums[i]).toList();
        List<Integer> vals = split.get(false).stream().map(i -> nums[i]).toList();
        var original = new int[lens.stream().mapToInt(n -> n).sum()];
        int k = 0;
        for (int i = 0; i < lens.size(); i++) {
            int n = vals.get(i);
            for (int j = lens.get(i); j > 0; j--) {
                original[k++] = n;
            }
        }
        return original;
    }
}
