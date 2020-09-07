class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int len = 0, sum = 0, left = 0;
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                var l = i - left + 1;
                if (len == 0 || l < len) {
                    len = l;
                }
                sum -= nums[left++];
            }
        }
        return len;
    }

    // java Solution.java "7" "[2,3,1,2,4,3]" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], nums = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, nums = %s",
                new Solution().minSubArrayLen(Integer.parseInt(s), intArr(nums)), expected, s, nums));
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
