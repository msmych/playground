import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        return occurrences(target).equals(occurrences(arr));
    }
    
    private Map<Integer, Integer> occurrences(int[] arr) {
        return stream(arr)
            .boxed()
            .collect(groupingBy(n -> n, summingInt(n -> 1)));
    }

    // java Solution.java "[1,2,3,4]" "[2,4,1,3]" "true" "[7]" "[7]" "true" "[1,12]" "[12,1]" "true" "[3,7,9]" "[3,7,11]" "false" "[1,1,1,1,1]" "[1,1,1,1,1]" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String target = args[i], arr = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: target = %s, arr = %s",
                new Solution().canBeEqual(array(target), array(arr)), expected, target, arr));
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
}
