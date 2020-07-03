import java.util.*;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        var next = new int[8];
        var states = new HashMap<Integer, Integer>();
        for (var i = 1; i < 7; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        System.arraycopy(next, 0, cells, 0, 8);
        N--;
        var state = state(cells);
        var n = 0;
        for (; n < N && !states.containsKey(state); n++) {
            states.put(state, n);
            for (var i = 1; i < 7; i++) {
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            System.arraycopy(next, 0, cells, 0, 8);
            state = state(cells);
        }
        if (n == N) {
            return cells;
        }
        var i = N % n;
        return states.entrySet().stream()
            .filter(e -> e.getValue() == i) 
            .findAny()
            .map(Map.Entry::getKey)
            .map(this::cells)
            .get();
    }

    private int state(int[] cells) {
        var state = 0;
        for (var i = 1; i < 7; i++) {
            if (cells[i] == 1) {
                state += 1 << i;
            }
        }
        return state;
    }

    private int[] cells(int state) {
        var cells = new int[8];
        for (var i = 1; i < 7; i++) {
            if ((state & (1 << i)) > 0) {
                cells[i] = 1;
            }
        }
        return cells;
    }

    // java Solution.java "[0,1,0,1,1,0,0,1]" "7" "[0,0,1,1,0,0,0,0]" "[1,0,0,1,0,0,1,0]" "1000000000" "[0,0,1,1,1,1,1,0]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String cells = args[i], N = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: cells = %s, N = %s",
                string(new Solution().prisonAfterNDays(array(cells), Integer.parseInt(N))), expected, cells, N));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
