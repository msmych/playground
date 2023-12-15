package uk.matvey.play.leet1436.java1;

import java.util.List;

public class Solution {

    public String destCity(List<List<String>> paths) {
        return paths.stream()
                .map(path -> path.get(1))
                .filter(destination -> paths.stream()
                        .map(path -> path.get(0))
                        .noneMatch(destination::equals))
                .findAny()
                .orElseThrow();
    }
}
