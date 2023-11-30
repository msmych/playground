package uk.matvey.play.leet1291.java1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final String DIGITS = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        return IntStream.rangeClosed(String.valueOf(low).length(), String.valueOf(high).length())
            .mapToObj(n -> IntStream.rangeClosed(0, DIGITS.length() - n)
                .mapToObj(i -> DIGITS.substring(i, i + n))
                .map(Integer::parseInt)
                .filter(i -> i >= low)
                .filter(i -> i <= high)
                .collect(Collectors.toList()))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
