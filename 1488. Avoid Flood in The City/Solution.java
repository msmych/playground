import java.util.*;

import static java.util.Arrays.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        return new int[0];
    }

    // java Solution.java "[1,2,3,4]" "[-1,-1,-1,-1]" "[1,2,0,0,2,1]" "[-1,-1,2,1,-1,-1]" "[1,2,0,1,2]" "[]" "[69,0,0,0,69]" "[-1,69,1,1,-1]" "[10,20,20]" "[]" "[0,1,1]" "[]" "[1,0,2,0,2,1]" "[-1,1,-1,2,-1,-1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String rains = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rains = %s",
                string(new Solution().avoidFlood(array(rains))), expected, rains));
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
