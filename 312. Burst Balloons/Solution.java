class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = balloons[balloons.length - 1] = 1;
        int[][] dp = new int[balloons.length][balloons.length];
        for (int k = 2; k < balloons.length; k++) {
            for (int left = 0; left < balloons.length - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    int coins = balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right];
                    if (coins > dp[left][right]) {
                        dp[left][right] = coins;
                    }
                }
            }
        }
        return dp[0][balloons.length - 1];
    }

    // java Solution.java "[3,1,5,8]" 167
    public static void main(String... args) {
        Solution solution = new Solution();
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                solution.maxCoins(array(nums)), expected, nums));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}