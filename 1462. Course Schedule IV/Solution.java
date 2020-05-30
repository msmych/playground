import java.util.*;

import static java.util.Collections.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    private final Map<List<Integer>, Boolean> cache = new HashMap<>();
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        for (var prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[0], new HashSet<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        return stream(queries)
            .map(q -> isPrerequisite(q[0], q[1]))
            .collect(toList());
    }
    
    private boolean isPrerequisite(int a, int b) {
        if (cache.containsKey(List.of(a, b))) {
            return cache.get(List.of(a, b));
        }
        if (map.getOrDefault(a, emptySet()).stream().anyMatch(c -> c == b || isPrerequisite(c, b))) {
            cache.put(List.of(a, b), true);
            return true;
        } else {
            cache.put(List.of(a, b), false);
            return false;
        }
    }

    // java Solution.java "2" "[[1,0]]" "[[0,1],[1,0]]" "[false,true]" "2" "[]" "[[1,0],[0,1]]" "[false,false]" "3" "[[1,2],[1,0],[2,0]]" "[[1,0],[1,2]]" "[true,true]" "3" "[[1,0],[2,0]]" "[[0,1],[2,0]]" "[false,true]" "5" "[[0,1],[1,2],[2,3],[3,4]]" "[[0,4],[4,0],[1,3],[3,0]]" "[true,false,true,false]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], prerequisites = args[i + 1], queries = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, prerequisites = %s, queries = %s",
                new Solution().checkIfPrerequisite(Integer.parseInt(n), array(prerequisites), array(queries)), expected, n, prerequisites, queries));
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
