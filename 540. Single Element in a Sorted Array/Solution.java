class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            var mid = left + (right - left) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid % 2 == 1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return left == 0 || nums[left] != nums[left - 1] ? nums[left] : nums[right];
    }

    // java Solution.java "[1,1,2,3,3,4,4,8,8]" "2" "[3,3,7,7,10,11,11]" "10"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().singleNonDuplicate(array(nums)), expected, nums));
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
