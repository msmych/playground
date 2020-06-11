class Solution {
    public int combinationSum4(int[] nums, int target) {
        var dp = new int[target + 1];
        dp[0] = 1;
        for (var i = 1; i < dp.length; i++) {
            for (var num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // java Solution.java "[1, 2, 3]" "4" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().combinationSum4(array(nums), Integer.parseInt(target)), expected, nums, target));
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
