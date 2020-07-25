import static java.lang.Math.*;

class Solution {

    private int[] nums;

    public int findMin(int[] nums) {
        this.nums = nums;
        return findMin(0, nums.length - 1);
    }

    private int findMin(int left, int right) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int mid = left + (right - left) / 2;
        int val = nums[mid];
        int rightMin = findMin(mid + 1, right);
        int leftMin = mid == 0 || val < nums[mid - 1] ? val : findMin(left, mid - 1);
        return min(leftMin, rightMin);
    }

    // java Solution.java "[1,3,5]" "1" "[2,2,2,0,1]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMin(array(nums)), expected, nums));
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
