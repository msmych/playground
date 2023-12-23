package uk.matvey.play.leet1496.java1;

import java.util.HashSet;

public class Solution {

    private record Point(
            int i,
            int j
    ) {}

    public boolean isPathCrossing(String path) {
        var visited = new HashSet<Point>();
        var p = new Point(0, 0);
        visited.add(p);
        for (var step : path.toCharArray()) {
            p = switch (step) {
                case 'N' -> new Point(p.i + 1, p.j);
                case 'S' -> new Point(p.i - 1, p.j);
                case 'E' -> new Point(p.i, p.j + 1);
                case 'W' -> new Point(p.i, p.j - 1);
                default -> p;
            };
            if (visited.contains(p)) {
                return true;
            }
            visited.add(p);
        }
        return false;
    }
}
