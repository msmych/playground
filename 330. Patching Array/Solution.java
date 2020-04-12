class Solution {
    public int minPatches(int[] nums, int n) {
        return 0;
    }

    // java Solution.java "[1,3]" "6" "1" "[1,5,10]" "20" "2" "[1,2,2]" "5" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, n = %s",
                new Solution().minPatches(array(nums), Integer.parseInt(n)), expected, nums, n));
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
