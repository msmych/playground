class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var positive = false;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++) {
            if (nums1[i] > 0) {
                positive = true;
            }
            if (nums1[i] >= nums2[j]) {
                if (nums1.length - 1 - i >= 0) {
                    System.arraycopy(nums1, i, nums1, i + 1, nums1.length - 1 - i);
                }
                nums1[i] = nums2[j++];
            } else if (positive && nums1[i] == 0 || nums1[i] == 0 && nums1.length - i <= nums2.length - j) {
                nums1[i] = nums2[j++];
            }
        }
    }

    // java Solution.java "[1,2,3,0,0,0]" "3" "[2,5,6]" "3" "[1,2,2,3,5,6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 5) {
            var nums1 = intArr(args[i]);
            String m = args[i + 1], nums2 = args[i + 2], n = args[i + 3], expected = args[i + 4];
            new Solution().merge(nums1, Integer.parseInt(m), intArr(nums2), Integer.parseInt(n));
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums1 = %s, m = %s, nums2 = %s, n = %s",
                string(nums1), expected, args[i], m, nums2, n)); 
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
