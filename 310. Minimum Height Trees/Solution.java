import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return singletonList(0);
        }
        var nodes = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            if (!nodes.containsKey(edge[0])) {
                nodes.put(edge[0], new HashSet<>());
            }
            nodes.get(edge[0]).add(edge[1]);
            if (!nodes.containsKey(edge[1])) {
                nodes.put(edge[1], new HashSet<>());
            }
            nodes.get(edge[1]).add(edge[0]);
        }
        var leaves = nodes.entrySet().stream()
            .filter(e -> e.getValue().size() == 1)
            .map(Map.Entry::getKey)
            .collect(toSet());
        while (n > 2) {
            n -= leaves.size();
            var nextLeaves = new HashSet<Integer>();
            for (int leaf : leaves) {
                int node = nodes.get(leaf).iterator().next();
                nodes.get(node).remove(leaf);
                if (nodes.get(node).size() == 1) {
                    nextLeaves.add(node);
                }
            }
            leaves = nextLeaves;
        }
        return new ArrayList<>(leaves);
    }

    // java Solution.java "4" "[[1, 0], [1, 2], [1, 3]]" "[1]" "6" "[[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]" "[3,4]" 6 "[[0,1],[0,2],[0,3],[3,4],[4,5]]" "[3]" 1 "[]" "[0]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], edges = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, edges = %s",
                new Solution().findMinHeightTrees(Integer.parseInt(n), array(edges)), expected, n, edges));
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
