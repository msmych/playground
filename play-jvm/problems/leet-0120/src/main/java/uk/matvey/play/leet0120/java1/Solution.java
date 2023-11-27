package uk.matvey.play.leet0120.java1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private static class LevelIndex {
        int level, i;

        LevelIndex(int level, int i) {
            this.level = level;
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LevelIndex that = (LevelIndex) o;
            return level == that.level &&
                i == that.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, i);
        }
    }

    private final Map<LevelIndex, Integer> cache = new HashMap<>();
    private List<List<Integer>> triangle;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        this.triangle = triangle;
        return nextMin(0, 0);
    }

    private int nextMin(int level, int i) {
        if (level >= triangle.size()) {
            return 0;
        }
        var levelIndex = new LevelIndex(level, i);
        if (cache.containsKey(levelIndex)) {
            return cache.get(levelIndex);
        }
        var row = triangle.get(level);
        int min = row.get(i) + Math.min(nextMin(level + 1, i), nextMin(level + 1, i + 1));
        cache.put(levelIndex, min);
        return min;
    }
}
