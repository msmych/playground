import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var map = stream(edges).collect(toMap(edge -> edge[1], edge -> edge[0]));
        var time = 0;
        for (var i = 0; i < hasApple.size(); i++) {
            if (!hasApple.get(i)) {
                continue;
            }
            var parent = i;
            while (parent != 0 && map.containsKey(parent)) {
                var node = map.get(parent);
                map.remove(parent);
                parent = node;
                time += 2;
            }
        }
        return time;
    }

    // java Solution.java "7" "[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]" "[false,false,true,false,true,true,false]" "8" "7" "[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]" "[false,false,true,false,false,true,false]" "6" "7" "[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]" "[false,false,false,false,false,false,false]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], edges = args[i + 1], hasApple = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, edges = %s, hasApple = %s",
                new Solution().minTime(Integer.parseInt(n), array(edges), list(hasApple)), expected, n, edges, hasApple));
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

    private static List<Boolean> list(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new ArrayList<>();
        var elements = s.split(",");
        var list = new ArrayList<Boolean>();
        for (var element : elements) {
            list.add(element.equals("true"));
        }
        return list;
    }
}

