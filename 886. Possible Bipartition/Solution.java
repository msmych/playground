import java.util.*;

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        var map = new HashMap<Integer, Set<Integer>>();
        for (var dislike : dislikes) {
            map.putIfAbsent(dislike[0], new HashSet<>());
            map.get(dislike[0]).add(dislike[1]);
            map.putIfAbsent(dislike[1], new HashSet<>());
            map.get(dislike[1]).add(dislike[0]);
        }
        while (!map.isEmpty()) {
            var evenVisited = new HashSet<Integer>();
            var oddVisited = new HashSet<Integer>();
            var n = map.keySet().iterator().next();
            var counter = 0;
            while (true) {
                if (!map.containsKey(n)) {
                    break;
                }
                var next = map.get(n).iterator().next();
                if (counter % 2 == 0) {
                    if (evenVisited.contains(next)) {
                        return false;
                    }
                    evenVisited.add(n);
                } else {
                    if (oddVisited.contains(next)) {
                        return false;
                    }
                    oddVisited.add(n);
                }
                if (map.get(n).size() == 1) {
                    map.remove(n);
                } else {
                    map.get(n).remove(next);
                }
                if (map.get(next).size() == 1) {
                    map.remove(next);
                } else {
                    map.get(next).remove(n);
                }
                n = next;
                counter++;
            }
        }
        return true;
    }

    // java Solution.java "4" "[[1,2],[1,3],[2,4]]" "true" "3" "[[1,2],[1,3],[2,3]]" "false" "5" "[[1,2],[2,3],[3,4],[4,5],[1,5]]" "false" 10 "[[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]" true
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String N = args[i], dislikes = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: N = %s, dislikes = %s",
                new Solution().possibleBipartition(Integer.parseInt(N), array(dislikes)), expected, N, dislikes));
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
