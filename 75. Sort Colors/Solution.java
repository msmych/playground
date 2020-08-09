class Solution {

    public void sortColors(int[] nums) {
        var colors = new int[3];
        for (var num : nums) {
            colors[num]++;
        }
        var i = 0;
        for (var color = 0; color < colors.length; color++) {
            for (var j = colors[color]; j > 0; j--) {
                nums[i++] = color;
            }
        }
    }

    // java Solution.java "[2,0,2,1,1,0]" "[0,0,1,1,2,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var nums = intArr(args[i]);
            String expected = args[i + 1];
            new Solution().sortColors(nums);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(nums), expected, args[i]));
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
