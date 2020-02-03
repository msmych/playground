import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

class Solution {
    public int minSetSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        List<Integer> occurrences = stream(arr)
            .boxed()
            .collect(groupingBy(n -> n, summingInt(n -> 1)))
            .values()
            .stream()
            .sorted(reverseOrder())
            .collect(toList()); 
        int i = 0;
        for (int sum = 0; sum < arr.length / 2; i++) {
            sum += occurrences.get(i);
        }
        return i; 
    }

    // java Solution.java "[3,3,3,3,5,5,5,2,2,7]" "2" "[7,7,7,7,7,7]" "1" "[1,9]" "1" "[1000,1000,3,7]" "1" "[1,2,3,4,5,6,7,8,9,10]" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().minSetSize(array(arr)), expected, arr));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
