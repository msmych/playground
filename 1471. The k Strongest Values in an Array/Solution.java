import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        sort(arr);
        var median = arr[(arr.length - 1) / 2];
        return stream(arr)
            .boxed()
            .sorted(comparingInt((Integer n) -> abs(n - median)).thenComparingInt(n -> n).reversed())
            .mapToInt(n -> n)
            .limit(k)
            .toArray();
    }

    // java Solution.java "[1,2,3,4,5]" "2" "[5,1]" "[1,1,3,5,5]" "2" "[5,5]" "[6,7,11,7,6,8]" "5" "[11,8,6,6,7]" "[6,-3,7,2,11]" "3" "[-3,11,2]" "[-7,22,17,3]" "2" "[22,17]" "[-2,-4,-6,-8,-9,-7,-5,-3,-1]" 3 "[-1,-9,-2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String arr = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, k = %s",
                string(new Solution().getStrongest(array(arr), Integer.parseInt(k))), expected, arr, k));
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
