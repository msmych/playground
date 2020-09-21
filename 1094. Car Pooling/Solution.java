import java.util.*;

class Solution {

    private static class Position {
        int position;
        int passengers;
        boolean isPickUp;

        Position(int position, int passengers, boolean isPickUp) {
            this.position = position;
            this.passengers = passengers;
            this.isPickUp = isPickUp;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        var positions = new ArrayList<Position>();
        for (var trip : trips) {
            positions.add(new Position(trip[1], trip[0], true));
            positions.add(new Position(trip[2], trip[0], false));
        }
        positions.sort((p1, p2) -> {
            if (p1.position != p2.position) {
                return p1.position > p2.position ? 1 : -1;
            }
            if (!p1.isPickUp && p2.isPickUp) {
                return -1;
            }
            if (p1.isPickUp && !p2.isPickUp) {
                return 1;
            }
            return 0;
        });
        var passengers = 0;
        for (var p : positions) {
            if (p.isPickUp) {
                passengers += p.passengers;
            } else {
                passengers -= p.passengers;
            }
            if (passengers > capacity) {
                return false;
            }
        }
        return true;
    }

    // java Solution.java "[[2,1,5],[3,3,7]]" "4" "false" "[[2,1,5],[3,3,7]]" "5" "true" "[[2,1,5],[3,5,7]]" "3" "true" "[[3,2,7],[3,7,9],[8,3,9]]" "11" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String trips = args[i], capacity = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: trips = %s, capacity = %s",
                new Solution().carPooling(intArrArr(trips), Integer.parseInt(capacity)), expected, trips, capacity));
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
}
