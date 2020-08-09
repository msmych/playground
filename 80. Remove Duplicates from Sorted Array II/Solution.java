class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        var k = 0;
        for (var i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] || nums[i] != nums[i + 1]) {
                k++;
            }
            nums[k] = nums[i];
        }
        nums[++k] = nums[nums.length - 1];
        return k + 1;
    }

    // java Solution.java "[1,1,1,2,2,3]" "5" "[0,0,1,1,1,1,2,3,3]" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().removeDuplicates(intArr(nums)), expected, nums));
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
