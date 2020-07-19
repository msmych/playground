class Solution {
    public int firstMissingPositive(int[] nums) {
        var m = nums.length + 1;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }
        for (var i = 0; i < nums.length; i++) {
            var previous = nums[i] % m;
            if (previous > 0) {
                nums[previous - 1] = (previous * m) + nums[previous - 1] % m;
            }
        }
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] / m != i + 1) {
                return i + 1;
            }
        }
        return m;
    }

    // java Solution.java "[1,2,0]" "3" "[3,4,-1,1]" "2" "[7,8,9,11,12]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().firstMissingPositive(array(nums)), expected, nums));
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
