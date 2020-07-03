class Solution {
    public int numSubseq(int[] nums, int target) {
        return 0;
    }

    // java Solution.java "[3,5,6,7]" "9" "4" "[3,3,6,8]" "10" "6" "[2,3,3,4,6,7]" "12" "61" "[5,2,4,1,7,6,8]" "16" "127"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().numSubseq(array(nums), Integer.parseInt(target)), expected, nums, target));
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
