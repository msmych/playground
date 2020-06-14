import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        var map = new HashMap<Integer, Set<Integer>>();
        var costs = new HashMap<List<Integer>, Integer>();
        for (var flight : flights) {
            map.putIfAbsent(flight[0], new HashSet<>());
            map.get(flight[0]).add(flight[1]);
            costs.put(List.of(flight[0], flight[1]), flight[2]);
        }
        var queue = new LinkedList<int[]>();
        queue.offer(new int[]{src, 0});
        var min = -1;
        while (K >= -1) {
            for (var size = queue.size(); size > 0; size--) {
                var last = queue.poll();
                if (last[0] == dst) {
                    if (min == -1 || last[1] < min) {
                        min = last[1];
                    }
                } else if (map.containsKey(last[0])) {
                    for (var next : map.get(last[0])) {
                        if (min == -1 || last[1] + costs.get(List.of(last[0], next)) <= min) {
                            queue.offer(new int[]{next, last[1] + costs.get(List.of(last[0], next))});
                        }
                    }
                }
            }
            K--;
        }
        return min;
    }

    // java Solution.java "3" "[[0,1,100],[1,2,100],[0,2,500]]" "0" "2" "1" "200" "3" "[[0,1,100],[1,2,100],[0,2,500]]" "0" "2" "0" "500" 5 "[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]" 2 1 1 -1 10 "[[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]" 6 0 7 14
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 6) {
            String n = args[i], flights = args[i + 1], src = args[i + 2], dst = args[i + 3], K = args[i + 4], expected = args[i + 5];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, flights = %s, src = %s, dst = %s, K = %s",
                new Solution().findCheapestPrice(Integer.parseInt(n), array(flights), Integer.parseInt(src), Integer.parseInt(dst), Integer.parseInt(K)), expected, n, flights, src, dst, K));
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
