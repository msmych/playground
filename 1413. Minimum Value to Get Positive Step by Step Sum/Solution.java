class Solution {
    public int minStartValue(int[] nums) {
        var initialValue = 1;
        for (int i = 0, value = initialValue; i < nums.length; i++) {
            value += nums[i];
            if (value < 1) {
                initialValue += 1 - value;
                value += 1 - value;
            }
        }
        return initialValue;
    }

    // java Solution.java "[-3,2,-3,4,2]" "5" "[1,2]" "1" "[1,-2,-3]" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().minStartValue(array(nums)), expected, nums));
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
