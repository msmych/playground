import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var uniques = stream(arr)
            .boxed()
            .collect(groupingBy(n -> n, summingInt(n -> 1)))
            .entrySet().stream()
            .sorted(comparingInt(Map.Entry::getValue))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        for (var iterator = uniques.entrySet().iterator(); iterator.hasNext() && k > 0;) {
            var count = iterator.next().getValue();
            k -= count;
            if (k >= 0) {
                iterator.remove();
            }
        }
        return uniques.size();
    }

    // java Solution.java "[5,5,4]" "1" "1" "[4,3,1,1,3,3,2]" "3" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String arr = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, k = %s",
                new Solution().findLeastNumOfUniqueInts(array(arr), Integer.parseInt(k)), expected, arr, k));
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
