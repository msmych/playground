class Solution {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[to];
            nums[to] = nums[from];
            nums[from] = temp;
            from++;
            to--;
        }
    }

    // java Solution.java "[1,2,3,4,5,6,7]" "3" "[5,6,7,1,2,3,4]" "[-1,-100,3,99]" "2" "[3,99,-1,-100]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            var nums = intArr(args[i]);
            var k = Integer.parseInt(args[i + 1]);
            String expected = args[i + 2];
            new Solution().rotate(nums, k);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                string(nums), expected, args[i], k));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
