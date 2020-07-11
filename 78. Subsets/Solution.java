import java.util.*;

import static java.lang.Math.*;
import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var subsets = new ArrayList<List<Integer>>();
        var nBit = 1 << nums.length;
        return range(0, (int) pow(2, nums.length))
            .mapToObj(i -> Integer.toBinaryString(i | nBit).substring(1))
            .map(bitmask -> range(0, nums.length)
                .filter(j -> bitmask.charAt(j) == '1')
                .mapToObj(j -> nums[j])
                .collect(toList()))
            .collect(toList());
    }

    // java Solution.java "[1,2,3]" "[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().subsets(array(nums)), expected, nums));
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
