import java.util.*;

import static java.util.Comparator.*;

class Solution {

    public String largestTimeFromDigits(int[] A) {
        var times = new HashMap<Integer, String>();
        for (var h1 = 0; h1 < A.length; h1++) {
            for (var h2 = 0; h2 < A.length; h2++) {
                if (h1 == h2) {
                    continue;
                }
                for (var m1 = 0; m1 < A.length; m1++) {
                    if (h1 == m1 || h2 == m1) {
                        continue;
                    }
                    for (var m2 = 0; m2 < A.length; m2++) {
                        if (h1 == m2 || h2 == m2 || m1 == m2) {
                            continue;
                        }
                        if (A[h1] > 2) {
                            continue;
                        }
                        if (A[h1] == 2 && A[h2] > 3) {
                            continue;
                        }
                        if (A[m1] > 5) {
                            continue;
                        }
                        times.put(A[h1] * 1000 + A[h2] * 100 + A[m1] * 10 + A[m2], String.valueOf(A[h1]) + A[h2] + ":" + A[m1] + A[m2]);
                    }
                }
            }
        }
        return times.isEmpty() ? "" : times.entrySet().stream().max(comparingInt(Map.Entry::getKey)).get().getValue();
    }

    // java Solution.java "[1,2,3,4]" "23:41" "[5,5,5,5]" ""
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String A = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s",
                new Solution().largestTimeFromDigits(intArr(A)), expected, A));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
