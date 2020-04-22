class Solution {
    public int subarraySum(int[] nums, int k) {
        var sums = new int[nums.length + 1];
        for (var i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        var count = 0;
        for (var i = 1; i < sums.length; i++) {
            for (var j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // java Solution.java "[1,1,1]" "2" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                new Solution().subarraySum(array(nums), Integer.parseInt(k)), expected, nums, k));
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
