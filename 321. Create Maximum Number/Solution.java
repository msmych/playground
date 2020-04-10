import static java.lang.Math.max;

class Solution {

    private int k;

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        this.k = k;
        var num = new int[k];
        for (var i = max(0, k - nums2.length); i <= k && i <= nums1.length; i++) {
            var candidate = merge(maxArr(nums1, i), maxArr(nums2, k - i));
            if (isGreater(candidate, 0, num, 0)) {
                num = candidate;
            }
        }
        return num;
    }

    private int[] maxArr(int[] nums, int k) {
        var arr = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums.length - i + j > k && j > 0 && arr[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                arr[j++] = nums[i];
            }
        }
        return arr;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        var arr = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            arr[r] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return arr;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    // java Solution.java "[3, 4, 6, 5]" "[9, 1, 2, 5, 8, 3]" 5 "[9, 8, 6, 5, 3]" "[6, 7]" "[6, 0, 4]" "5" "[6, 7, 6, 0, 4]" "[3, 9]" "[8, 9]" "3" "[9, 8, 9]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String nums1 = args[i], nums2 = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums1 = %s, nums2 = %s, k = %s",
                string(new Solution().maxNumber(array(nums1), array(nums2), Integer.parseInt(k))), expected, nums1, nums2, k));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
