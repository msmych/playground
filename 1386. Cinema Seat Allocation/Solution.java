import java.util.Set;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.rangeClosed;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int families = 0;
        Map<Integer, Set<Integer>> reserved = stream(reservedSeats)
            .collect(groupingBy(seat -> seat[0]))
            .entrySet().stream()
            .collect(toMap(Map.Entry::getKey, e -> e.getValue().stream()
                .map(seat -> seat[1]).collect(toSet())));
        for (Set<Integer> row : reserved.values()) {
            if (rangeClosed(2, 9).noneMatch(s -> row.contains(s))) {
                families += 2;
            } else if (rangeClosed(2, 5).noneMatch(s -> row.contains(s)) ||
                rangeClosed(4, 7).noneMatch(s -> row.contains(s)) ||
                rangeClosed(6, 9).noneMatch(s -> row.contains(s))) {
                families++;
            }
        }
        families += 2 * (n - reserved.size());
        return families;
    }

    // java Solution.java "3" "[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]" "4" "2" "[[2,1],[1,8],[2,6]]" "2" "4" "[[4,3],[1,4],[4,6],[1,7]]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], reservedSeats = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, reservedSeats = %s",
                new Solution().maxNumberOfFamilies(Integer.parseInt(n), array(reservedSeats)), expected, n, reservedSeats));
        }
    }

    private static int[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new int[0][0];
        int[][] arr = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(elements[j]);
        }
        return arr;
    }
}
