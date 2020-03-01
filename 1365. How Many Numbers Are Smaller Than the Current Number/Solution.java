import java.util.Map;
import java.util.HashMap;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        arraycopy(nums, 0, arr, 0, nums.length);
        sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1, last = arr[0]; i < arr.length; i++) {
            if (arr[i] != last) {
                map.put(arr[i], i);
                last = arr[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    // java Solution.java "[8,1,2,2,3]" "[4,0,1,1,3]" "[6,5,4,8]" "[2,1,0,3]" "[7,7,7,7]" "[0,0,0,0]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(new Solution().smallerNumbersThanCurrent(array(nums))), expected, nums));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
