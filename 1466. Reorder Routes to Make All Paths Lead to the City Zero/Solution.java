import java.util.*;

class Solution {

    private final Set<Integer> visited = new HashSet<>();
    private final Map<Integer, Set<Integer>> original = new HashMap<>();
    private final Map<Integer, Set<Integer>> reversed = new HashMap<>();

    public int minReorder(int n, int[][] connections) {
        for (var i = 0; i < n; i++) {
            original.putIfAbsent(i, new HashSet<>());
            reversed.putIfAbsent(i, new HashSet<>());
        }
        for (var connection : connections) {
            original.get(connection[1]).add(connection[0]);
            reversed.get(connection[0]).add(connection[1]);
        }
        return nextReorder(0);
    }

    private int nextReorder(int i) {
        if (visited.contains(i)) {
            return 0;
        }
        visited.add(i);
        var reorder = 0;
        for (var next : original.get(i)) {
            reorder += nextReorder(next);
        }
        for (var next : reversed.get(i)) {
            if (visited.contains(next)) {
                continue;
            }
            reorder++;
            reorder += nextReorder(next);
        }
        return reorder;
    }

    // java Solution.java "6" "[[0,1],[1,3],[2,3],[4,0],[4,5]]" "3" "5" "[[1,0],[1,2],[3,2],[3,4]]" "2" "3" "[[1,0],[2,0]]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], connections = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, connections = %s",
                new Solution().minReorder(Integer.parseInt(n), array(connections)), expected, n, connections));
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
