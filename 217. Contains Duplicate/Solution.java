import java.util.*;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        var numSet = new HashSet<Integer>();
        for (var num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }

    // java Solution.java "[1,2,3,1]" "true" "[1,2,3,4]" "false" "[1,1,1,3,3,4,3,2,4,2]" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().containsDuplicate(intArr(nums)), expected, nums));
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
