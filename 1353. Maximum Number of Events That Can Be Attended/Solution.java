import java.util.Queue;
import java.util.PriorityQueue;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;

class Solution {
    public int maxEvents(int[][] events) {
        Queue<Integer> queue = new PriorityQueue<>();
        sort(events, comparingInt(event -> event[0]));
        int attended = 0;
        for (int day = 1, i = 0; day <= 100000; day++) {
            while (queue.size() > 0 && queue.peek() < day) {
                queue.poll();
            }
            while (i < events.length && events[i][0] == day) {
                queue.offer(events[i++][1]);
            }
            if (queue.size() > 0) {
                queue.poll();
                attended++;
            }
        }
        return attended;
    }

    // java Solution.java "[[1,2],[2,3],[3,4]]" "3" "[[1,2],[2,3],[3,4],[1,2]]" "4" "[[1,4],[4,4],[2,2],[3,4],[1,1]]" "4" "[[1,100000]]" "1" "[[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]" "7" "[[1,3],[1,3],[1,3],[3,4]]" 4 "[[1,2],[1,2],[3,3],[1,5],[1,5]]" 5 "[[1,2],[2,2],[3,3],[3,4],[3,4]]" 4 "[[25,26],[19,19],[9,13],[16,17],[17,18],[20,21],[22,25],[11,12],[19,23],[7,9],[1,1],[21,23],[14,14],[4,7],[16,16],[24,28],[16,18],[4,5],[18,20],[16,16],[25,26]]" 19
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String events = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: events = %s",
                new Solution().maxEvents(array(events)), expected, events));
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
