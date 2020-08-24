import java.util.*;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        return null;
    }

    // java Solution.java "6" "[[0,1],[0,2],[2,5],[3,4],[4,2]]" "[0,3]" "5" "[[0,1],[2,1],[3,1],[1,4],[2,4]]" "[0,2,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], edges = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, edges = %s",
                new Solution().findSmallestSetOfVertices(Integer.parseInt(n), integerListList(edges)), expected, n, edges));
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
