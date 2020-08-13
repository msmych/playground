import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return new ArrayList<>(nextPower(stream(nums).boxed().collect(toList())));
    }

    private Set<List<Integer>> nextPower(List<Integer> nums) {
        var power = new HashSet<List<Integer>>();
        if (nums.isEmpty()) {
            power.add(new ArrayList<>());
            return power;
        }
        power.add(nums);
        for (var num : new HashSet<>(nums)) {
            var next = new ArrayList<>(nums);
            next.remove(Integer.valueOf(num));
            power.addAll(nextPower(next));
        }
        return power;
    }

    // java Solution.java "[1,2,2]" "[[2],[1],[1,2,2],[2,2],[1,2],[]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().subsetsWithDup(intArr(nums)), expected, nums));
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
