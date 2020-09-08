import java.util.*;

import static java.util.Comparator.*;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = toMap(nums);
        for (var indexes : map.values()) {
            indexes.sort(naturalOrder());
            for (var i = 0; i < indexes.size() - 1; i++) {
                if (indexes.get(i + 1) - indexes.get(i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> toMap(int[] nums) {
        var map = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
        }
        return map;
    }

    // java Solution.java "[1,2,3,1]" "3" "true" "[1,0,1,1]" "1" "true" "[1,2,3,1,2,3]" "2" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                new Solution().containsNearbyDuplicate(intArr(nums), Integer.parseInt(k)), expected, nums, k));
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
