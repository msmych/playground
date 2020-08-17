import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private final Map<Set<Integer>, Integer> cache = new HashMap<>();

    public int numTrees(int n) {
        return getNum(range(1, n + 1).boxed().collect(toSet()));
    }

    private int getNum(Set<Integer> nums) {
        if (nums.isEmpty()) {
            return 0;
        }
        if (nums.size() == 1) {
            return 1;
        }
        if (cache.containsKey(nums)) {
            return cache.get(nums);
        }
        var count = 0;
        for (var num : nums) {
            int left = getNum(nums.stream().filter(n -> n < num).collect(toSet())),
                right = getNum(nums.stream().filter(n -> n > num).collect(toSet()));
            if (left == 0 || right == 0) {
                count += left + right;
            } else {
                count += left * right;
            }
        }
        cache.put(nums, count);
        return count;
    }

    // java Solution.java "3" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().numTrees(Integer.parseInt(n)), expected, n));
        }
    }
}
