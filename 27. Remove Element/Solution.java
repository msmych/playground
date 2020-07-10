class Solution {
    public int removeElement(int[] nums, int val) {
        var k = 0;
        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }

    // java Solution.java "[3,2,2,3]" "3" "2" "[0,1,2,2,3,0,4,2]" "2" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], val = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, val = %s",
                new Solution().removeElement(array(nums), Integer.parseInt(val)), expected, nums, val));
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
