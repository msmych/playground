import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        var set = stream(nums).boxed().collect(toSet());
        return rangeClosed(1, nums.length)
            .filter(n -> !set.contains(n))
            .boxed()
            .collect(toList());
    }

    // java Solution.java "[4,3,2,7,8,2,3,1]" "[5,6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findDisappearedNumbers(array(nums)), expected, nums));
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
