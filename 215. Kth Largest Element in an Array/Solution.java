import static java.util.Arrays.*;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length - k];
    }

    // java Solution.java "[3,2,1,5,6,4]" "2" "5" "[3,2,3,1,2,4,5,5,6]" "4" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                new Solution().findKthLargest(intArr(nums), Integer.parseInt(k)), expected, nums, k));
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
