import java.util.*;

import static java.lang.Math.*;

class Solution {

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
        int min = row.get(i) + min(nextMin(level + 1, i), nextMin(level + 1, i + 1));
        cache.put(levelIndex, min);
        return min;
    }

    // java Solution.java "[[2],[3,4],[6,5,7],[4,1,8,3]]" "11"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String triangle = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: triangle = %s",
                new Solution().minimumTotal(integerListList(triangle)), expected, triangle));
        }
    }

    private static List<List<Integer>> integerListList(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new ArrayList<>();
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new ArrayList<>();
        var list = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows.length; i++) {
            var elements = rows[i].split(",");
            var row = new ArrayList<Integer>();
            for (int j = 0; j < elements.length; j++)
            row.add(Integer.parseInt(elements[j]));
            list.add(row);
        }
        return list;
    }
}
