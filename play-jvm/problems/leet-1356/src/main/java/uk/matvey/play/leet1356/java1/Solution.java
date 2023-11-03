package uk.matvey.play.leet1356.java1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .sorted(
                Comparator.comparing(n -> Integer.toBinaryString((Integer) n).chars().filter(c -> c == '1').count())
                    .thenComparing(n -> (Integer) n)
            )
            .mapToInt(n -> n)
            .toArray();
    }
}
