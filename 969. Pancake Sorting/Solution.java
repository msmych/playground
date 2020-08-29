import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.Comparator.*;

class Solution {

    public List<Integer> pancakeSort(int[] A) {
        var flips = new ArrayList<Integer>();
        var right = A.length - 1;
        while (range(0, right).anyMatch(i -> A[i] > A[i + 1])) {
            var maxIndex = rangeClosed(0, right).boxed().max(comparingInt(i -> A[i])).get();
            if (maxIndex == right) {
                right--;
                continue;
            }
            if (maxIndex != 0) {
                flip(A, maxIndex);
                flips.add(maxIndex + 1);
            }
            flip(A, right);
            flips.add(right + 1);
            right--;
        }
        return flips;
    }

    private void flip(int[] arr, int i) {
        for (var j = 0; j <= i / 2; j++) {
            var t = arr[j];
            arr[j] = arr[i - j];
            arr[i - j] = t;
        }
    }

    // java Solution.java "[3,2,4,1]" "[4,2,4,3]" "[1,2,3]" "[]" "[2,1,3]" "[2,3,2,2,1,1,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String A = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s",
                new Solution().pancakeSort(intArr(A)), expected, A));
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
