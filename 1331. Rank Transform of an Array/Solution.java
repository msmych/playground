import java.util.Map;
import java.util.HashMap;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = new int[arr.length];
        arraycopy(arr, 0, sorted, 0, arr.length);
        sort(sorted);
        for (int i = 0, rank = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], ++rank);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    // java Solution.java "[40,10,20,30]" "[4,1,2,3]" "[100,100,100]" "[1,1,1]" "[37,12,28,9,100,56,80,5,12]" "[5,3,4,2,8,6,7,1,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                string(new Solution().arrayRankTransform(array(arr))), expected, arr));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
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
