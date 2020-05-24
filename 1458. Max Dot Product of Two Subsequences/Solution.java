class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        return 0;
    }

    // java Solution.java "[2,1,-2,5]" "[3,0,-6]" "18" "[3,-2]" "[2,-6,7]" 21 "[-1,-1]" "[1,1]" -1
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums1 = args[i], nums2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums1 = %s, nums2 = %s",
                new Solution().maxDotProduct(array(nums1), array(nums2)), expected, nums1, nums2));
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
