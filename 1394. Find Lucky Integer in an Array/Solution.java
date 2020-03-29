import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

class Solution {
    public int findLucky(int[] arr) {
        return stream(arr)
            .boxed()
            .collect(groupingBy(n -> n, summingInt(n -> 1)))
            .entrySet().stream()
            .filter(e -> e.getKey() == e.getValue())
            .map(Map.Entry::getKey)
            .sorted(reverseOrder())
            .findFirst()
            .orElse(-1);
    }

    // java Solution.java "[2,2,3,4]" "2" "[1,2,2,3,3,3]" "3" "[2,2,2,3,3]" "-1" "[5]" "-1" "[7,7,7,7,7,7,7]" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().findLucky(array(arr)), expected, arr));
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
