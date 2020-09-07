import java.util.*;

class Solution {

    public void wallsAndGates(int[][] rooms) {
        for (var y = 0; y < rooms.length; y++) {
            for (var x = 0; x < rooms[0].length; x++) {
                if (rooms[y][x] == 0) {
                    var visited = new HashSet<Integer>();
                    var queue = new LinkedList<Integer>();
                    queue.add((y << 16) + x);
                    var d = 0;
                    while (!queue.isEmpty()) {
                        for (var size = queue.size(); size > 0; size--) {
                            var p = queue.poll();
                            int i = p >> 16, j = (p << 16) >> 16;
                            if (d > 0) {
                                if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1 || rooms[i][j] <= d || visited.contains((i << 16) + j)) {
                                    continue;
                                }
                                rooms[i][j] = d;
                            }
                            visited.add(p);
                            queue.offer((i << 16) + j - 1);
                            queue.offer(((i - 1) << 16) + j);
                            queue.offer((i << 16) + j + 1);
                            queue.offer(((i + 1) << 16) + j);
                        }
                        d++;
                    }
                }
            }
        }
    }

    // java Solution.java "[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]" "[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]" "[[0,2147483647,-1,2147483647,2147483647,-1,-1,0,0,-1,2147483647,2147483647,0,-1,2147483647,2147483647,2147483647,2147483647,0,2147483647,0,-1,-1,-1,-1,2147483647,-1,-1,2147483647,2147483647,-1,-1,0,0,-1,0,0,0,2147483647,0,2147483647,-1,-1,0,-1,0,0,0,2147483647],[2147483647,0,-1,2147483647,0,-1,-1,-1,-1,0,0,2147483647,2147483647,-1,-1,2147483647,-1,-1,2147483647,2147483647,-1,0,-1,2147483647,0,2147483647,-1,2147483647,0,2147483647,0,2147483647,-1,2147483647,0,2147483647,-1,2147483647,0,2147483647,2147483647,0,-1,2147483647,-1,-1,-1,0,2147483647]]" "[[0,1,-1,2,1,-1,-1,0,0,-1,1,1,0,-1,4,3,2,1,0,1,0,-1,-1,-1,-1,2,-1,-1,1,2,-1,-1,0,0,-1,0,0,0,1,0,1,-1,-1,0,-1,0,0,0,1],[1,0,-1,1,0,-1,-1,-1,-1,0,0,1,1,-1,-1,4,-1,-1,1,2,-1,0,-1,1,0,1,-1,1,0,1,0,1,-1,1,0,1,-1,1,0,1,1,0,-1,1,-1,-1,-1,0,1]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var rooms = intArrArr(args[i]);
            new Solution().wallsAndGates(rooms);
            String expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rooms = %s",
                string(rooms), expected, args[i]));
        }
    }

    private static int[][] intArrArr(String s) {
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
            for (var j = 0; j < arr[i].length; j++) arr[i][j] = Integer.parseInt(els[j]);
        }
        return arr;
    }

    private static String string(int[][] arr) {
        String s = "";
        for (int[] row : arr) {
            String r = "";
            for (int n : row) r += "," + n;
            if (row.length > 0) r = r.substring(1);
            s += ",[" + r + "]";
        }
        if (arr.length > 0) s = s.substring(1);
        return "[" + s + "]";
    }
}
