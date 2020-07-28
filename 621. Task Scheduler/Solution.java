import static java.lang.Math.*;
import static java.util.Arrays.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        var schedule = new int[26];
        for (var task : tasks) {
            schedule[task - 'A']++;
        }
        sort(schedule);
        int max = schedule[25] - 1, idle = max * n;
        for (var i = 24; i >= 0 && schedule[i] > 0; i--) {
            idle -= min(schedule[i], max);
        }
        return idle > 0 ? tasks.length + idle : tasks.length;
    }

    // java Solution.java "[A,A,A,B,B,B]" "2" "8" "[A,A,A,B,B,B]" "0" "6" "[A,A,A,A,A,A,B,C,D,E,F,G]" "2" "16"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String tasks = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: tasks = %s, n = %s",
                new Solution().leastInterval(array(tasks), Integer.parseInt(n)), expected, tasks, n));
        }
    }

    private static char[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0];
        var els = s.split(",");
        var arr = new char[els.length];
        for (var i = 0; i < els.length; i++) arr[i] = els[i].charAt(0);
        return arr;
    }
}
