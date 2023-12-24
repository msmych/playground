package uk.matvey.play.leet1366.java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String rankTeams(String[] votes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            var set = votes[0].chars().mapToObj(c -> (char) c)
                    .filter(c -> !sb.toString().contains(c.toString()))
                    .collect(Collectors.toSet());
            for (int j = 0; j < votes[0].length(); j++) {
                int index = j;
                var map = Arrays.stream(votes).map(vote -> vote.charAt(index)).filter(set::contains)
                        .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
                var max = map.values().stream().mapToInt(v -> v).max();
                if (max.isPresent()) {
                    var next = map.entrySet().stream().filter(e -> e.getValue() == max.getAsInt())
                            .map(Map.Entry::getKey).collect(Collectors.toSet());
                    if (next.size() == 1) {
                        sb.append(next.iterator().next());
                        break;
                    }
                    set = next;
                }
            }
            if (sb.length() == i) {
                sb.append(set.stream().min(Comparator.naturalOrder()).get());
            }
        }
        return sb.toString();
    }
}
