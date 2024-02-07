package uk.matvey.play.leet0451.java1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String frequencySort(String s) {
        return s.chars()
            .mapToObj(Character::toString)
            .collect(Collectors.groupingBy(c -> c))
            .values()
            .stream()
            .sorted(Comparator.comparing(List::size, Comparator.reverseOrder()))
            .map(list -> String.join("", list))
            .collect(Collectors.joining());
    }
}
