import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var duplicates = new ArrayList<Integer>();
        var els = new HashSet<Integer>();
        for (var num : nums) {
            if (els.contains(num)) {
                duplicates.add(num);
            } else {
                els.add(num);
            }
        }
        return duplicates;
    }

    // java Solution.java "[4,3,2,7,8,2,3,1]" "[2,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findDuplicates(intArr(nums)), expected, nums));
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
