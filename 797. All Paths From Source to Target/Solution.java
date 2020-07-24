import java.util.*;

class Solution {

    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        return paths(new ArrayList<>(), 0);
    }

    private List<List<Integer>> paths(List<Integer> path, int n) {
        path.add(n);
        if (n == graph.length - 1) {
            return List.of(path);
        }
        var paths = new ArrayList<List<Integer>>();
        for (var node : graph[n]) {
            paths.addAll(paths(new ArrayList<>(path), node));
        }
        return paths;
    }

    // java Solution.java "[[1,2], [3], [3], []]" "[[0,1,3],[0,2,3]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String graph = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: graph = %s",
                new Solution().allPathsSourceTarget(array(graph)), expected, graph));
        }
    }

    private static int[][] array(String s) {
        s = s.replace(" ", "");
        if (s.equals("[[]]")) return new int[0][0];
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        var arr = new int[rows.length][];
        for (var i = 0; i < arr.length; i++) {
            var row = rows[i].replace("[", "").replace("]", "");
            if (row.isEmpty()) {
                arr[i] = new int[0];
                continue;
            }
            var els = row.split(",");
            arr[i] = new int[els.length];
            for (var j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(els[j]);
        }
        return arr;
    }

}
