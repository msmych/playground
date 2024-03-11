package uk.matvey.problems.leet0791;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {

    public String customSortString(String order, String s) {
        return s.chars()
            .boxed()
            .sorted(Comparator.comparingInt(order::indexOf))
            .map(Character::toString)
            .collect(Collectors.joining());
    }
}
