class Solution {

    public int removeDuplicates(int[] nums) {
        var k = 0;
        Integer last = null;
        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (last == null || num != last) {
                nums[k++] = num;
                last = num;
            }
        }
        return k;
    }

    // java Solution.java "[1,1,2]" "2" "[0,0,1,1,1,2,2,3,3,4]" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().removeDuplicates(array(nums)), expected, nums));
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
