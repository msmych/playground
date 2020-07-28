class Solution {

    public boolean canJump(int[] nums) {
        var good = nums.length - 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= good) {
                good = i;
            }
        }
        return good == 0;
    }

    // java Solution.java "[2,3,1,1,4]" "true" "[3,2,1,0,4]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().canJump(array(nums)), expected, nums));
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
